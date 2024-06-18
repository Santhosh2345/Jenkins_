package com.Logs;

public class ArrayOfObjects {

        public static void main(String[] args) {

            //Array of objects
            Players[] pl = new Players[2];
            pl[0] = new Players(1,2);
            pl[1] = new Players(3, 4);

            System.out.println("Player[0] ");
            pl[0].player();
            System.out.println("Player[0] ");
            pl[1].player();
        }
    }

    class Players{
        int a;
        int b;
        Players(int a, int b){
            this.a = a;
            this.b = b;
        }

        void player(){
            System.out.println(a+b);
        }
    }