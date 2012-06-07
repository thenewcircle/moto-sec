package com.marakana.android.virusscanner;

import java.util.List;

import android.app.Activity;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PermissionInfo;
import android.os.Bundle;
import android.widget.TextView;

public class VirusScannerActivity extends Activity {
	TextView out;
	PackageManager pm;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		out = (TextView) findViewById(R.id.out);

		pm = getPackageManager();
		List<PackageInfo> list = pm
				.getInstalledPackages(PackageManager.GET_PERMISSIONS);

		for (PackageInfo info : list) {
			out.append( String.format("\n%s", info.packageName) );
			PermissionInfo perms[] = info.permissions;
			if(perms==null) continue;
			for( PermissionInfo perm: perms)  {
				out.append( String.format("\n   %s", perm.name) );
			}
		}
	}
}