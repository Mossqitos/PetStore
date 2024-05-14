package org.acme.PetAPI;

public class Tag {

        private int Tid;
        private String Tname;

        public Tag(int Tid, String Tname) {
            this.Tid = Tid;
            this.Tname = Tname;
        }

        public Tag() {
        }
        public int getTId() {
            return Tid;
        }

        public void setTId(int Tid) {
            this.Tid = Tid;
        }

        public String getTName() {
            return Tname;
        }

        public void setTName(String Tname) {
            this.Tname = Tname;
        }
    }

