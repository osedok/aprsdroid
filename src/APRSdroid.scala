package org.aprsdroid.app

import _root_.android.app.Activity
import _root_.android.content.Intent
import _root_.android.os.Bundle
import _root_.android.preference.PreferenceManager

class APRSdroid extends Activity {
	def replaceAct(act : Class[_]) {
		val i = new Intent(this, act)
		i.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP)
		startActivity(i)
		finish()
	}

	override def onCreate(savedInstanceState : Bundle) {
		super.onCreate(savedInstanceState)
		val prefs = PreferenceManager.getDefaultSharedPreferences(this)
		prefs.getString("activity", "log") match {
		case "hub" => replaceAct(classOf[HubActivity])
		case "map" => replaceAct(classOf[MapAct])
		case _ => replaceAct(classOf[LogActivity])
		}
	}
}
