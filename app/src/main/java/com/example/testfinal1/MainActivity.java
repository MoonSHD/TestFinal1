package com.example.testfinal1;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;

import androidx.fragment.app.FragmentTransaction;

import com.example.testfinal1.fragment.Fragment1;
import com.example.testfinal1.fragment.Fragment2;
import com.example.testfinal1.fragment.Fragment3;
import com.example.testfinal1.fragment.Fragment4;


public class MainActivity extends AppCompatActivity {

    Button btn1;
    Button btn2;
    Button btn3;
    Button btn4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = (Button) findViewById(R.id.btn_1);
        btn2 = (Button) findViewById(R.id.btn_2);
        btn3 = (Button) findViewById(R.id.btn_3);
        btn4 = (Button) findViewById(R.id.btn_4);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                Fragment1 fragment1 = new Fragment1();
                transaction.replace(R.id.frame, fragment1);
                //transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                Fragment2 fragment2 = new Fragment2();
                transaction.replace(R.id.frame, fragment2);
                //transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                Fragment3 fragment3 = new Fragment3();
                transaction.replace(R.id.frame, fragment3);
                //transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                Fragment4 fragment4 = new Fragment4();
                transaction.replace(R.id.frame, fragment4);
                //transaction.addToBackStack(null);
                transaction.commit();
            }
        });
    }
}

//        MapView mapView = new MapView(this);
//
//
//        ViewGroup mapViewContainer = (ViewGroup) findViewById(R.id.map_view); //????????? ??????
//        mapViewContainer.addView(mapView);
//
//        //????????? ??????
//        //mapView.setCurrentLocationTrackingMode(MapView.CurrentLocationTrackingMode.TrackingModeOnWithoutHeading);
//
//        //Searchparser(?????????)
//        SearchParser searchParser = new SearchParser();
//
//
//        //Coordparse (?????????)
//        CoordParser apiData = new CoordParser();
//
//
//        //PolyLineSeter?????????
//        //PolylineSeter polylineSeter = new PolylineSeter();
//
//
//        //???????????? (?????????)
//        TextView textView1 = (TextView) findViewById(R.id.text1) ;
//
//        //??????(SearchView) ?????????
//        SearchView searchView = findViewById(R.id.SearchView1);
//        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//            @Override
//            public boolean onQueryTextSubmit(String s) {
//                ArrayList<SearchCoord> scData = searchParser.getCoord(s);
//                ArrayList<CoorData> dataArr = apiData.getData(scData.get(0).SearchHelper());
//                //polylineSeter.set_poly(mapView, dataArr);
//
//                return true;
//            }
//
//            @Override
//            public boolean onQueryTextChange(String s) {
//                return false;
//            }
//        });
//
//    }
//
//
//class SearchCoord {
//    String x;
//    String y;
//    public String SearchHelper() {
//        Double minX = Double.parseDouble(x)-0.01;
//        Double maxX = Double.parseDouble(x)+0.01;
//        Double minY = Double.parseDouble(y)-0.01;
//        Double maxY = Double.parseDouble(y)+0.01;
//        String result = minX.toString()+","+minY.toString()+","+maxX.toString()+","+maxY.toString()+")";
//        return result;
//    }
//}
//
//class SearchParser {
//    public ArrayList<SearchCoord> getCoord(String mName) {
//        //return data ??????
//        ArrayList<SearchCoord> searchCoords = new ArrayList<SearchCoord>();
//        Thread t = new Thread() {
//            @Override
//            public void run() {
//                try {
//                    //?????? Url
//                    String searchUrl = "https://api.vworld.kr/req/search?service=search&request=search&version=2.0&crs=EPSG:4326&size=10&page=1&type=place&format=xml&errorformat=xml&key=F931BD24-945F-3AA9-8CB7-853B5D40C5A8&query=" + mName;
//                    URL url = new URL(searchUrl);
//                    InputStream is = url.openStream();
//
//                    //xmlParser ??????
//                    XmlPullParserFactory xmlFactory = XmlPullParserFactory.newInstance();
//                    XmlPullParser parser = xmlFactory.newPullParser();
//                    parser.setInput(is,"utf-8");
//
//                    //xml??? ????????? ?????????
//                    boolean isTitle = false;
//                    boolean isThat = false;
//                    boolean isFirst = true;
//                    boolean isCate = false;
//                    boolean isMount = false;
//                    boolean isX = false;
//                    boolean isY = false;
//                    String X = "";
//                    String Y = "";
//                    String Title = "";
//                    String Cate = "";
//
//                    // ?????? ??????
//                    while(parser.getEventType() != XmlPullParser.END_DOCUMENT) {
//                        int type = parser.getEventType();
//                        SearchCoord sc = new SearchCoord();
//
//                        //?????? ??????(????????? gml:posList??? ?????? ??????)
//                        if(type == XmlPullParser.START_TAG) {
//                            if (parser.getName().equals("category")) {
//                                isCate = true;
//                            }
//                            else if(parser.getName().equals("title")){
//                                isTitle = true;
//                            }
//                            else if(parser.getName().equals("x")){
//                                isX = true;
//                            }
//                            else if(parser.getName().equals("y")){
//                                isY = true;
//                            }
//                        }
//
//                        else if(type == XmlPullParser.TEXT) { //???????????????
//                            if(isTitle){ //????????? ???????????? ???
//                                if(isFirst){
//                                    Title = parser.getText();
//                                }
//                                if(parser.getText()==Title){
//                                    isThat = true;
//                                }
//                                isTitle = false;
//                            }
//                            else if(isCate) { //????????? ??????????????????
//                                if(isFirst){
//                                    Cate = parser.getText();
//                                    isFirst = false;
//                                }
//                                if(parser.getText()==Cate){//????????? ????????? ????????????
//                                    isMount = true; //??? ???????????? ????????? ??????
//                                }
//                                isCate = false; //???????????? ?????? ???
//                            }
//                            else if(isX) { //????????? x??? ???
//                                if(isThat && isMount){ //???????????? ????????? ????????????
//                                    X = parser.getText(); //x?????? X??? ??????
//                                }
//                                isX = false; //x ?????? ???
//                            }
//                            else if(isY) { //????????? y??? ???
//                                if(isThat && isMount) { //???????????? ????????? ????????????
//                                    Y = parser.getText(); // y?????? Y??? ??????
//                                }
//                                isY = false; //y ?????? ???
//                            }
//                        }
//
//                        // y????????? ?????? ???????????? ?????? ()
//                        else if(type == XmlPullParser.END_TAG && parser.getName().equals("y") && isThat && isMount) {
//                            sc.x = X;
//                            sc.y = Y;
//                            searchCoords.add(sc);
//                            isThat = false; // ??? ???????????? ?????? x,y ?????? ?????? ???????????????
//                            isMount = false; //isThat??? isMount ?????????
//                        }
//
//
//                        type = parser.next();
//                    }
//
//                } catch (MalformedURLException e) {
//                    e.printStackTrace();
//                } catch (XmlPullParserException e) {
//                    e.printStackTrace();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        };
//        try {
//            t.start();
//            t.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        return searchCoords;
//    }
//}
//
//class CoorData {
//    String[] Coords;
//}
//
//class CoordParser {
//    public ArrayList<CoorData> getData(String boxData) {
//        //return data ??????
//        ArrayList<CoorData> dataArr = new ArrayList<CoorData>();
//        Thread t = new Thread() {
//            @Override
//            public  void run() {
//                try {
//                    //?????? Url
//                    String fullurl = "https://api.vworld.kr/req/data?service=data&version=2.0&request=getfeature&key=F931BD24-945F-3AA9-8CB7-853B5D40C5A8&domain=http://localhost:8080&format=xml&data=LT_L_FRSTCLIMB&crs=epsg:4326&geomfilter=BOX("+boxData;
//                    URL url = new URL(fullurl);
//                    InputStream is = url.openStream();
//
//                    //xmlParser ??????
//                    XmlPullParserFactory xmlFactory = XmlPullParserFactory.newInstance();
//                    XmlPullParser parser = xmlFactory.newPullParser();
//                    parser.setInput(is,"utf-8");
//
//                    //xml??? ????????? ?????????
//                    boolean isCoords = false;
//                    String Coords = "";
//
//                    // ?????? ??????
//                    while(parser.getEventType() != XmlPullParser.END_DOCUMENT) {
//                        int type = parser.getEventType();
//                        CoorData data = new CoorData();
//
//                        //?????? ??????(????????? gml:posList??? ?????? ??????)
//                        if(type == XmlPullParser.START_TAG) {
//                            if (parser.getName().equals("gml:posList")) {
//                                isCoords = true;
//                            }
//                        }
//                        //????????? ?????? (Coords??? ????????? ?????? ??????)
//                        else if(type == XmlPullParser.TEXT) {
//                            if(isCoords) {
//                                Coords = parser.getText();
//                                isCoords = false;
//                            }
//                        }
//                        // ????????? ?????? (Coords????????? ???????????? ??????????????? ??????)
//                        else if(type == XmlPullParser.END_TAG && parser.getName().equals("gml:posList")) {
//                            data.Coords = Coords.split(" ");
//
//                            dataArr.add(data);
//                        }
//
//                        type = parser.next();
//                    }
//                } catch (MalformedURLException e) {
//                    e.printStackTrace();
//                } catch (XmlPullParserException e) {
//                    e.printStackTrace();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        };
//        try {
//            t.start();
//            t.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        return dataArr;
//    }
//}
//
//class PolylineSeter {
//    public void set_poly(MapView mapView, ArrayList<CoorData> dataArr) {
//        // Polyline ?????? ??????.
//        mapView.removeAllPolylines();
//        for(int i=0; i<dataArr.size(); i++) { // ??? CoorData?????? ???????????? ?????? ??????
//            MapPolyline polyline = new MapPolyline();
//            polyline.setLineColor(Color.argb(128, i*10, 51, 0));
//            polyline.setTag(1000);
//            for(int x=0; x<dataArr.get(i).Coords.length/2; x++) {
//                polyline.addPoint(MapPoint.mapPointWithGeoCoord(Double.parseDouble(dataArr.get(i).Coords[x*2+1]), Double.parseDouble(dataArr.get(i).Coords[x*2])));
//            }
//            mapView.addPolyline(polyline); // ???????????? ?????? ????????? ?????????
//        }
//
//        // ???????????? ??????????????? ???????????? Polyline??? ?????? ???????????? ??????.
//        mapView.fitMapViewAreaToShowAllPolylines();
//    }
//}