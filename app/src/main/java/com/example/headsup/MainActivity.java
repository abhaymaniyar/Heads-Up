package com.example.headsup;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private CardViewAdapter adapter;
    private List<Categories> categoriesList;
    private Map<String, List<String>> stringsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        categoriesList = new ArrayList<>();
        stringsList = new HashMap<String, List<String>>() {
            @Override
            public int size() {
                return stringsList.size();
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean containsKey(Object key) {
                return false;
            }

            @Override
            public boolean containsValue(Object value) {
                return false;
            }

            @Override
            public List<String> get(Object key) {
                return super.get(key);
            }

            @Override
            public List<String> put(String key, List<String> value) {
                return super.put(key, value);
            }

            @Override
            public List<String> remove(Object key) {
                return super.remove(key);
            }

            @Override
            public void putAll(@NonNull Map<? extends String, ? extends List<String>> m) {

            }

            @Override
            public void clear() {

            }

            @NonNull
            @Override
            public Set<String> keySet() {
                return super.keySet();
            }

            @NonNull
            @Override
            public Collection<List<String>> values() {
                return super.values();
            }

            @NonNull
            @Override
            public Set<Entry<String, List<String>>> entrySet() {
                return null;
            }
        };
        adapter = new CardViewAdapter(this, categoriesList, stringsList);
        prepareCategories();
        try {
            prepareStrings();
        } catch (IOException e) {
            e.printStackTrace();
        }

        GridLayoutManager layoutManager = new GridLayoutManager(this, 2);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
    }

    private void prepareCategories() {
        int[] covers = new int[]{
                R.drawable.album1,
                R.drawable.album2,
                R.drawable.album3,
                R.drawable.album4,
                R.drawable.album5,
                R.drawable.album6,
                R.drawable.album7,
                R.drawable.album8
        };

        categoriesList.add(new Categories("Movies", 15, covers[0]));
        categoriesList.add(new Categories("Songs", 15, covers[1]));
        categoriesList.add(new Categories("Act it out", 15, covers[2]));
        categoriesList.add(new Categories("Game of Thrones", 15, covers[3]));
        categoriesList.add(new Categories("Actors", 15, covers[4]));
        categoriesList.add(new Categories("Green Earth", 15, covers[5]));
        categoriesList.add(new Categories("Dialogues", 15, covers[6]));

        adapter.notifyDataSetChanged();

    }

    private void prepareStrings() throws IOException {
        InputStreamReader streamReader = new InputStreamReader(getAssets().open("movies.txt"));
        BufferedReader bufferedReader = new BufferedReader(streamReader);
        int ch;
        String str = "";
        while((ch = bufferedReader.read()) != -1){
            str += (char)ch;
        }

        String[] strArray = str.split(",");
        ArrayList<String> moviesString = new ArrayList<>(35);
        for (int i = 0; i < strArray.length; i++){
            moviesString.add(strArray[i]);
        }
//        moviesString.add("Kabhi Khushi kabhi bum");
//        moviesString.add("Dil Chahta hai");
//        moviesString.add("Hero");
//        moviesString.add("Raja Hindustani");
//        moviesString.add("Ram Lakhan");
//        moviesString.add("Fast and Furious");
//        moviesString.add("Hello Brother");
//        moviesString.add("Rang de Basanti");
//        moviesString.add("Bajarangi Bhaijan");
//        moviesString.add("Gangs of Wasseypur");
//        moviesString.add("Dus");
//        moviesString.add("Sholay");
//        moviesString.add("Kaho na pyaar he");
//        moviesString.add("Koi Mil gaya");
//        moviesString.add("Dharam Veer");
//        moviesString.add("Karan Arjun");
//        moviesString.add("Mere Badle ki Aag");
//        moviesString.add("Aan - Man at Work");
//        moviesString.add("Pardes");
//        moviesString.add("Jis desh me Ganga rehta he");
//        moviesString.add("Baahubali - The conclusion");
//        moviesString.add("Mother India");
//        moviesString.add("Koora Kagaj");
//        moviesString.add("Jharokha");
//        moviesString.add("Shola aur Shabnam");
//        moviesString.add("Koyla");
//        moviesString.add("Krrish");
//        moviesString.add("Dhamaal");
//        moviesString.add("Kashmir ki Kali");
//        moviesString.add("Main hoon na!");
//        moviesString.add("Andaz apna apna");
//        moviesString.add("Padosan");
//        moviesString.add("Jabaaz");
//        moviesString.add("Befikre");
//        moviesString.add("Mr. India");
//        moviesString.add("Kaypo Che");
//        moviesString.add("Janwar");
        stringsList.put(categoriesList.get(0).getName(), moviesString);
        ArrayList<String> songsString = new ArrayList<>(24);
        songsString.add("Koi tumsa nahi");
        songsString.add("Tera chehra jab nazar");
        songsString.add("Na na na re");
        songsString.add("Dil Ibadat");
        songsString.add("Mohabattein");
        songsString.add("Ek pal ka jeena");
        songsString.add("Kaho na pyaar he");
        songsString.add("Kyu Chalti he pawan");
        songsString.add("Juli Juli");
        songsString.add("Jimmy Jimmy aaj aaja");
        songsString.add("Me nikla gaddi leke");
        songsString.add("Musafir jane wale");
        songsString.add("Koi mujhe jungli kahe");
        songsString.add("Mohabbat barsa dena tu");
        songsString.add("Sawan me lag gayi aag");
        songsString.add("Tunak Tunak tun tarara");
        songsString.add("Satyam Shivam Sundaram");
        songsString.add("Baharo full barsao");
        songsString.add("Barso re megha megha");
        songsString.add("Ye jo des he tera");
        songsString.add("I love my India");
        songsString.add("Ab tumhare hawale watan sathiyo");
        songsString.add("Hamma hamma");
        songsString.add("Jumma Chumma dede");
        stringsList.put(categoriesList.get(1).getName(), songsString);
        ArrayList<String> actItOutString = new ArrayList<>(15);
        actItOutString.add("Sky Diving");
        actItOutString.add("Washing Clothes");
        actItOutString.add("Flying Kite");
        actItOutString.add("Making a Goal");
        actItOutString.add("Breaking the door and entering");
        actItOutString.add("Making a cup of tea");
        actItOutString.add("Playing Cricket");
        actItOutString.add("Smoking Weed");
        actItOutString.add("Teaching a class");
        actItOutString.add("Doing pushups");
        actItOutString.add("Serving Pani puri");
        actItOutString.add("Laughing at you");
        actItOutString.add("1Playing Cricket");
        actItOutString.add("2Smoking Weed");
        actItOutString.add("3Teaching a class");
        actItOutString.add("4Doing pushups");
        actItOutString.add("5Serving Pani puri");
        actItOutString.add("6Laughing at you");
        stringsList.put(categoriesList.get(2).getName(), actItOutString);
        ArrayList<String> actorString = new ArrayList<>(25);
        actorString.add("Shatrugun Sinha");
        actorString.add("Rajpal Yadav");
        actorString.add("Nargis Fakhri");
        actorString.add("Mallika Sherawat");
        actorString.add("Himesh Reshmiya");
        actorString.add("Salman Khan");
        actorString.add("Amir Khan");
        actorString.add("Abhishekh Bachchan");
        actorString.add("Jaya Bachchan");
        actorString.add("Sanjay Dutt");
        actorString.add("Varun Dhawan");
        actorString.add("Malika Arora");
        actorString.add("Sagarika Ghatage");
        actorString.add("Ritesh Deshmukh");
        actorString.add("Jhony Depp");
        actorString.add("Johny Lever");
        actorString.add("Angelina Jolie");
        actorString.add("Paresh Rawal");
        actorString.add("Kadar Khan");
        actorString.add("Govinda Khanna");
        actorString.add("Vivek Oberoi");
        actorString.add("Arjun Rampal");
        actorString.add("Katrina Kaif");
        actorString.add("Bobby Darling");
        actorString.add("Kamal R Khan");
        actorString.add("Prabhas");

        stringsList.put(categoriesList.get(3).getName(), actorString);
        ArrayList<String> greentEarthString = new ArrayList<>(15);
        greentEarthString.add("Naino Khushi kabhi bum");
        greentEarthString.add("Teri Chahta hai");
        greentEarthString.add("2Naino Khushi kabhi bum");
        greentEarthString.add("1Teri Chahta hai");
        greentEarthString.add("12Naino Khushi kabhi bum");
        greentEarthString.add("21Teri Chahta hai");
        greentEarthString.add("4Naino Khushi kabhi bum");
        greentEarthString.add("32Teri Chahta hai");
        greentEarthString.add("22Teri Chahta hai");
        greentEarthString.add("5Naino Khushi kabhi bum");
        greentEarthString.add("2111Teri Chahta hai");
        greentEarthString.add("111Teri Chahta hai");
        stringsList.put(categoriesList.get(4).getName(), greentEarthString);
        ArrayList<String> dialoguesString = new ArrayList<>(15);
        dialoguesString.add("Naino Khushi kabhi bum");
        dialoguesString.add("Teri Chahta hai");
        dialoguesString.add("2Naino Khushi kabhi bum");
        dialoguesString.add("1Teri Chahta hai");
        dialoguesString.add("12Naino Khushi kabhi bum");
        dialoguesString.add("21Teri Chahta hai");
        dialoguesString.add("4Naino Khushi kabhi bum");
        dialoguesString.add("32Teri Chahta hai");
        dialoguesString.add("22Teri Chahta hai");
        dialoguesString.add("5Naino Khushi kabhi bum");
        dialoguesString.add("2111Teri Chahta hai");
        dialoguesString.add("111Teri Chahta hai");
        stringsList.put(categoriesList.get(5).getName(), dialoguesString);
        ArrayList<String> gotString = new ArrayList<>(15);
        gotString.add("Naino Khushi kabhi bum");
        gotString.add("Teri Chahta hai");
        gotString.add("2Naino Khushi kabhi bum");
        gotString.add("1Teri Chahta hai");
        gotString.add("12Naino Khushi kabhi bum");
        gotString.add("21Teri Chahta hai");
        gotString.add("4Naino Khushi kabhi bum");
        gotString.add("32Teri Chahta hai");
        gotString.add("22Teri Chahta hai");
        gotString.add("5Naino Khushi kabhi bum");
        gotString.add("2111Teri Chahta hai");
        gotString.add("111Teri Chahta hai");
        stringsList.put(categoriesList.get(6).getName(), gotString);
        adapter.notifyDataSetChanged();
    }
}
