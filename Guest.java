public class Guest {
        private int guestId;
        private String name;
        private String email;
        private String phone;
        
        //constructor
        public Guest(int guestId, String name, String email, String phone){
            this.guestId=guestId;
            this.name=name;
            this.email=email;
            this.phone=phone;
        }
        public int getGuestId(){
            return guestId;
        }
        public String getName(){
            return name;
        }
        public String getEmail(){
            return email;
        }
        public String getPhone(){
            return phone;
        }

        public void setName(String name){
            this.name=name;
        }
        public void setEmail(String email){
            this.email=email;
        }
        public void setPhone(String phone){
            this.phone=phone;
        }

        public String getdetails(){
            return "Guest Id:"+ guestId+", Name:"+name+", email:"+email+", phone:"+ phone;
        }

    }

