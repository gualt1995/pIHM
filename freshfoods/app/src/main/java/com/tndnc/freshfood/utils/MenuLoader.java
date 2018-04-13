package com.tndnc.freshfood.utils;

import android.content.res.AssetManager;
import android.util.Log;
import android.util.SparseArray;
import android.util.Xml;

import com.tndnc.freshfood.MenuApplication;
import com.tndnc.freshfood.models.MenuItem;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MenuLoader {

    private static MenuItem lastLoadedMenuItem;

    public static void loadAllMenu(MenuApplication app) {
        AssetManager assetManager = app.getAssets();

        try (InputStream in = assetManager.open("Menu.xml")) {

            // initialise xml parser
            XmlPullParser parser = Xml.newPullParser();
            parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
            parser.setInput(in, null);
            parser.nextTag();

            // load Menu container
            SparseArray<List<MenuItem>> Menu = app.getMenuBySize();
            // parse xml
            parser.require(XmlPullParser.START_TAG, null, "menuItems");
            while(parser.next() != XmlPullParser.END_TAG) {
                if (parser.getEventType() != XmlPullParser.START_TAG) continue;

                String name = parser.getName();
                if (name.equals("menuItem")) {
                    MenuItem menuItem = parseItem(parser);
                    if (lastLoadedMenuItem != null) lastLoadedMenuItem.setNextMenuItem(menuItem);

                    Menu.get(menuItem.getSize()).add(menuItem);
                    Log.d("MenuLoader", "MenuItem loaded: " + menuItem);
                    if (lastLoadedMenuItem != null)
                        Log.d("MenuLoader", lastLoadedMenuItem.getName() + "-->" + lastLoadedMenuItem.getNextMenuItem().getName());
                    lastLoadedMenuItem = menuItem;
                } else {
                    skip(parser);
                }
            }

            lastLoadedMenuItem = null;
            in.close();

        } catch (IOException | XmlPullParserException | NullPointerException e) {
            e.printStackTrace();
        }
    }

    private static MenuItem parseItem(XmlPullParser parser) throws XmlPullParserException,
            IOException {

        String price;
        String id;
        int size;
        String shortdes = "";

        parser.require(XmlPullParser.START_TAG, null, "menuItem");
        id = parser.getAttributeValue(null, "name");
        size = Integer.parseInt(parser.getAttributeValue(null, "size"));
        price = parser.getAttributeValue(null, "price");
        while (parser.next() != XmlPullParser.END_TAG) {
            if (parser.getEventType() != XmlPullParser.START_TAG) continue;
            parser.require(XmlPullParser.START_TAG, null, "shortdes");
            shortdes = parser.getAttributeValue(null, "text");
        }
        parser.next();
        parser.next();

        return new MenuItem(id, size,price,shortdes);
    }


    private static void skip(XmlPullParser parser) throws XmlPullParserException, IOException {
        if (parser.getEventType() != XmlPullParser.START_TAG) {
            throw new IllegalStateException();
        }
        int depth = 1;
        while (depth != 0) {
            switch (parser.next()) {
                case XmlPullParser.END_TAG:
                    depth--;
                    break;
                case XmlPullParser.START_TAG:
                    depth++;
                    break;
            }
        }
    }
}
