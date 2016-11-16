package com.ayedevelopers.onetouchbalance;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

import android.widget.RemoteViews;



/**
 * Implementation of App Widget functionality.
 */
public class otbwidget extends AppWidgetProvider {

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {


        for (int appWidgetId : appWidgetIds) {
            final GlobalClass globalVariable = (GlobalClass)context.getApplicationContext();
            Intent intentc = new Intent(Intent.ACTION_CALL);
            Intent intents = new Intent(Intent.ACTION_CALL);
            Intent intentd = new Intent(Intent.ACTION_CALL);
            Intent intentcc = new Intent(Intent.ACTION_CALL);
            Intent intentrc = new Intent(context, MainActivity.class);
            String ussdCode = globalVariable.getmCodecb();
            String ussdCodee = globalVariable.getmCodesb();
            String ussdCodeee = globalVariable.getmCodedb();
            String customerCare = globalVariable.getmCodecc();
            intentc.setData(Uri.parse("tel:"+ussdCode));
            intents.setData(Uri.parse("tel:"+ussdCodee));
            intentd.setData(Uri.parse("tel:"+ussdCodeee));
            intentcc.setData(Uri.parse(customerCare));
            PendingIntent pendingIntentc = PendingIntent.getActivity(context, 0, intentc, 0);
            PendingIntent pendingIntents = PendingIntent.getActivity(context, 0, intents, 0);
            PendingIntent pendingIntentd = PendingIntent.getActivity(context, 0, intentd, 0);
            PendingIntent pendingIntentcc = PendingIntent.getActivity(context, 0, intentcc, 0);
            PendingIntent pendingIntentrc = PendingIntent.getActivity(context, 0, intentrc, 0);




            // Get the layout for the App Widget and attach an on-click listener to the button
            RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.otbwidget);
            views.setOnClickPendingIntent(R.id.callbutt, pendingIntentc);
            views.setOnClickPendingIntent(R.id.smsbutt, pendingIntents);
            views.setOnClickPendingIntent(R.id.databutt, pendingIntentd);
            views.setOnClickPendingIntent(R.id.splbutt, pendingIntentcc);
            views.setOnClickPendingIntent(R.id.rcharge, pendingIntentrc);


            // Tell the AppWidgetManager to perform an update on the current App Widget
            appWidgetManager.updateAppWidget(appWidgetId, views);

    }}





        public void onEnabled(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        // Enter relevant functionality for when the first widget is created

            onUpdate( context,  appWidgetManager, appWidgetIds);
        }



    public void onDisabled(Context context) {

        // Enter relevant functionality for when the last widget is disabled

    }

    static void updateAppWidget(Context context, AppWidgetManager appWidgetManager,
                                int[] appWidgetIds) {

        CharSequence widgetText = context.getString(R.string.appwidget_text);

    }


    @Override
    public void onReceive(Context context, Intent intent) {
        super.onReceive(context, intent);
}}


