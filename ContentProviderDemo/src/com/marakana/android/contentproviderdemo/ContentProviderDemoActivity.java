package com.marakana.android.contentproviderdemo;

import android.app.Activity;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.widget.TextView;

public class ContentProviderDemoActivity extends Activity {
	// private static final Uri URI = Contacts.CONTENT_URI;
	private static final Uri URI = Settings.System.CONTENT_URI;

	private TextView out;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		out = (TextView) findViewById(R.id.out);

		// Get the data
		Cursor cursor = getContentResolver().query(URI, null,
				null, null, null);

		// Dump the data
		while (cursor.moveToNext()) {
			for (int col = 0; col < cursor.getColumnCount(); col++) {
				out.append(cursor.getString(col) + " ");
			}
			out.append("\n");
		}
	}
}