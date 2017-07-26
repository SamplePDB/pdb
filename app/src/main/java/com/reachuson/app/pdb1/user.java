package com.reachuson.app.pdb1;

/**
 * Created by root on 24/7/17.
 */

public class user {

        //name and address string
        private String name;
        private String Instname;
        private String pin;
        private String type;
        private String number;

        public user() {
      /*Blank default constructor essential for Firebase*/
        }
        //Getters and setters
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getInst() {
            return Instname;
        }

        public void setInstname(String Instname) {
            this.Instname = Instname;
        }

        public String getpin() {
            return pin;
        }

        public void setpin(String pin) {
            this.pin = pin;
        }

        public void settype(String type) {
            this.type = type;
        }

        public String gettype() {
            return type;
        }

        public String getnumber(){return number;}

        public void setnumber(String Number){this.number = Number;}

}
