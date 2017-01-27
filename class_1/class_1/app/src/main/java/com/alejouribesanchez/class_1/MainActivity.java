package com.alejouribesanchez.class_1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    static String AndroidApi="Android 12";
    final static float pi = 3.1416f;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        JavaTypes javaTypes = new JavaTypes();
        javaTypes.show();
        javaTypes.operators();
        javaTypes.Bucles();

        String AndroidApi = MainActivity.AndroidApi;
            Log.d("JAVA","Android: " + AndroidApi);
        String AndroidApi2 = javaTypes.getAndroidApi();
            Log.d("JAVA","Android: " + AndroidApi2);

        MainActivity.AndroidApi = "Android Ice Sandwich";

        String AndroidApi3 = javaTypes.getAndroidApi();
         Log.d("JAVA","Android: " + AndroidApi3);

        javaTypes.changeAndroidApi();
        String AndroidApi4 = MainActivity.AndroidApi;
        Log.d("JAVA","Android: " + AndroidApi4);

        AndroidProject androidProject = new AndroidProject();
        String name = androidProject.name(19);
        Log.d("JAVA","Android Name: " + name);


    }

    //TODO learn java
    //TODO learn Android
    //TODO work in Yuxi

    public class JavaTypes {
        //Primitive
         boolean booleane = true;
         boolean isJava;
         boolean isAndroid = false;

         byte age = 1; //-128-127   8 bits
         short year = 2017; //-37768 y 32762 16 bits
         int numberPeople = 2000000; //32 bits
         long numberPlanets = 100000000; // 64 bits

         float resultDivision = 23.4f; //32 bits
         double operation =  56.2355f; //64 bits

         char oneCharacter = 'a'; //Unicode 16 bits

         //arrays
         int[] arrayIntegers = {1, 3, 5, 7, 9};
         int[] arrayInt = new int[3];

        //final
        final int age2 = 2;
        final String AndroidName = "JellyBean";

        //TODO Class final dont have subclass


        public void show() {
            arrayInt[0] = 9;
            arrayInt[1] = 11;
            arrayInt[2] = 31;

            Log.d("JAVA","array[0]: " + arrayInt[0]);
            Log.d("JAVA","array[1]: " + arrayInt[1]);
            Log.d("JAVA","array[2]: " + arrayInt[2]);
        }

        public void operators() {
            age++;
            Log.d("JAVA","age: " + age);
            ++age;
            Log.d("JAVA","age: " + age);
            ++age;
            Log.d("JAVA","age: " + age);
            year--;
            Log.d("JAVA","year: " + year);

            numberPeople = arrayInt[0]* arrayInt[1];
            Log.d("JAVA","numberPeople: " + numberPeople);

            age-=1;
            Log.d("JAVA","age: " + age);

            if(age == 2017){
                Log.d("JAVA","this year");
            }
            else {
                Log.d("JAVA","age: " + age);
            }

            String opcionElegida = "Android";

            switch (opcionElegida) {
                default:
                    Log.d("JAVA","Default");
                    break;
                case "Android1":
                    age*=2;
                    break;
                case "Android2":
                    age/=2;
                    break;
                case "Android3":
                    age+=2;
                    break;
                case "Android4":
                    age-=3;
                    break;
                case "Android":
                    age^=1;
                    break;
            }


        }

        public void Bucles() {
            while(age>2016){
                age++;
                Log.d("JAVA","WHILE");
                if(age>2030){
                    break;
                }
            }

            int sum = 0;
            for (int cnt = 1; cnt <= 10; cnt++) {
                sum += cnt;
            }

            Log.d("JAVA","La suma es: " + sum);

            for (int entero : arrayInt) {
                Log.d("JAVA",String.valueOf(entero));
            }
        }

        public String getAndroidApi() {
            return AndroidApi;
        }

        public void changeAndroidApi() {
            AndroidApi = "Android KitKat";
        }

    }

    public abstract class Android{
        abstract int age(int year);
        abstract String name(int api);
    }

    public class AndroidProject extends Android{

        @Override
        int age(int year) {
            return 2017-year;
        }

        @Override
        String name(int api) {
            String name="Undefined";
            switch (api) {
                case 1:
                    name = "Apple pie";
                    break;
                case 2:
                    name = "Banana Bread";
                    break;
                case 3:
                    name = "CupCake";
                    break;
                case 4:
                    name = "Donut";
                    break;
                case 7:
                    name = "Eclair";
                    break;
                case 8:
                    name = "Froyo";
                    break;
                case 10:
                    name = "Gingerbread";
                    break;
                case 13:
                    name = "Honeycomb";
                    break;
                case 15:
                    name = "Ice Cream Sandwich";
                    break;
                case 16:
                    name = "Jelly Bean";
                    break;
                case 17:
                    name = "Jelly Bean";
                    break;
                case 18:
                    name = "Jelly Bean";
                    break;
                case 19:
                    name = "KitKat";
                    break;
                case 20:
                    name = "Lollipop";
                    break;
                default:
                    name = "Lollipop";
                    break;
            }
            return name;
        }
    }

}
