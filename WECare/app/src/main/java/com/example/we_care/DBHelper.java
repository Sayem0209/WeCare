package com.example.we_care;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(Context context)
    {
        super(context, "User.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase DB)
    {
        DB.execSQL("create Table Infomation(Name TEXT, Address TEXT, UserID TEXT primary key, Password TEXT, Disease TEXT, Blood TEXT )");
        DB.execSQL("create Table Schools(Name TEXT, location TEXT,  EIIN TEXT primary key, Rating TEXT, Contact TEXT, Email TEXT,Special Text, fee TEXT)");

        DB.execSQL("insert into Schools(Name, location, EIIN, Rating, Contact, Email, Special, fee) values ('Proyash Cantonment', 'Chittagong','1459','4','01717876611','proyash@gmail.com','Asperger’s Syndrome','2000')" );
        DB.execSQL("insert into Schools(Name, location, EIIN, Rating, Contact, Email, Special, fee) values ('Autism Welfare Foundation', 'Dhaka','1234','5','01717874561','proyash@gmail.com','Rett Syndrome','3000')" );
        DB.execSQL("insert into Schools(Name, location, EIIN, Rating, Contact, Email, Special, fee) values ('Beautiful Mind', 'Dhaka','1876','3','01877876611','proyash@gmail.com','Childhood Disintegrative Disorder(CDD)','2500')" );
        DB.execSQL("insert into Schools(Name, location, EIIN, Rating, Contact, Email, Special, fee) values ('Nishpap Autism Foundation', 'Chittagong','9163','4','01917776641','proyash@gmail.com','Kanner’s Syndrome','2000')" );
        DB.execSQL("insert into Schools(Name, location, EIIN, Rating, Contact, Email, Special, fee) values ('Proyash Savar', 'Savar','3459','4','01416534256','proyash@gmail.com','Asperger’s Syndrome','2000')" );
        DB.execSQL("insert into Schools(Name, location, EIIN, Rating, Contact, Email, Special, fee) values ('School for Gifted Children', 'Rajshahi','1129','5','01711567231','proyash@gmail.com','Pervasive Developmental Disorder','2500')" );
        DB.execSQL("insert into Schools(Name, location, EIIN, Rating, Contact, Email, Special, fee) values ('William & Mary Taylor Inclusive School', 'Savar','7869','5','01618765432','proyash@gmail.com','Rett Syndrome','2000')" );
        //DB.execSQL("insert into Schools(Name, location, EIIN, Rating, Contact, Email, Special, fee) values ('Proyash Cantonment', 'Dhaka Cantonment','2349','5','01715643981','proyash@gmail.com','Asperger’s Syndrome','2000')" );
        DB.execSQL("insert into Schools(Name, location, EIIN, Rating, Contact, Email, Special, fee) values ('Autistic Children Welfare Foundation', 'Chittagong','7658','5','0161456611','proyash@gmail.com','Rett Syndrome','3000')" );



        DB.execSQL("create Table Doctor(ID INTEGER PRIMARY KEY AUTOINCREMENT, Name TEXT, Specialised TEXT, Location TEXT,qua TEXT,hospi TEXT,avai TEXT)");
        DB.execSQL("insert into Doctor(Name,Specialised,Location,qua,hospi,avai) values('Dr. Bonday Ali', 'Asperger’s Syndrome', 'Mahammadpur','MBBS','Ever Care','9 AM-5 PM')");
        DB.execSQL("insert into Doctor(Name,Specialised,Location,qua,hospi,avai) values('Prof. Dr. Md. Siraj Uddin', 'Asperger’s Syndrome', 'Lalbagh','MBBS','Ever Care','9 AM-5 PM')");


        DB.execSQL("insert into Doctor(Name,Specialised,Location,qua,hospi,avai) values('Dr. M. M. Jayed Hossain', 'Rett Syndrome', 'Lalmatia','MBBS','Ever Care','9 AM-5 PM')");
        DB.execSQL("insert into Doctor(Name,Specialised,Location,qua,hospi,avai) values('Prof. Dr. Md. Zulfiqar Hasan', 'Rett Syndrome', 'Mahammadpur','MBBS','Ever Care','9 AM-5 PM')");

        DB.execSQL("insert into Doctor(Name,Specialised,Location,qua,hospi,avai) values('Dr. Tahmina Banu', 'Childhood Disintegrative Disorder(CDD)', 'Chankharpul','MBBS','Ever Care','9 AM-5 PM')");
        DB.execSQL("insert into Doctor(Name,Specialised,Location,qua,hospi,avai) values('Dr. Bhabesh Chandra Mondal', 'Childhood Disintegrative Disorder(CDD)', 'Banani','MBBS','Ever Care','9 AM-5 PM')");

        DB.execSQL("insert into Doctor(Name,Specialised,Location,qua,hospi,avai) values('Dr. Md. Quamrul Islam', 'Pervasive Developmental Disorder', 'Dhanmondi','MBBS','Ever Care','9 AM-5 PM')");
        DB.execSQL("insert into Doctor(Name,Specialised,Location,qua,hospi,avai) values('Prof. Wahiuddin Mahmood', 'Pervasive Developmental Disorder', 'Muhammadpur','MBBS','Ever Care','9 AM-5 PM')");

        DB.execSQL("insert into Doctor(Name,Specialised,Location,qua,hospi,avai) values('Dr. Shah Muhammad Ali', 'Kanner’s Syndrome', 'Dhanmondi','MBBS','Ever Care','9 AM-5 PM')");
        DB.execSQL("insert into Doctor(Name,Specialised,Location,qua,hospi,avai) values('Dr. Syeda Ishrat Jahan', 'Kanner’s Syndrome', 'Banani','MBBS','Ever Care','9 AM-5 PM')");



        DB.execSQL("create Table NGO(Name TEXT, Establised TEXT, Details TEXT)");
        DB.execSQL("insert into NGO(Name, Establised, Details) values ('Shishu Bikash Kendra','1992','Shishu Bikash Kendra were first established in 1992 by the Dhaka Shishu Hospital, aiming to prevent disability, optimize development and improve the quality of survival for children with disabilities.\n')");
        DB.execSQL("insert into NGO(Name, Establised, Details) values ('Bangladesh Protibondi Foundation','1984','Bangladesh Protibondi Foundation is the pioneer organization in Bangladesh for addressing the rights of children with disabilities. Founded in 1984, its primary objective is to ensure that children with disabilities are included in mainstream society with equal rights, opportunities and dignity within a protective environment.\n" +
                "Write to\n')");
        DB.execSQL("insert into NGO(Name, Establised, Details) values ('BRAC Inclusive Educaton Programme','2003','BRAC, a development organization committed to social justice and empowerment of the poor and disadvantaged, has a comprehensive education programme. It provides free pre- primary and primary education to over 3 million children who are left out of the formal school system.')");
        DB.execSQL("insert into NGO(Name, Establised, Details) values ('Care','1998','CARE is one of the worlds largest international humanitarian organizations, committed to helping families in poor communities improve their lives and alleviate poverty. Founded in 1945, CARE is working across 104 countries to fight global poverty and marginalization.')");

        DB.execSQL("create Table NGOMessage(UserID TEXT, NGOName TEXT, PhoneNumber TEXT, Message TEXT)");
        DB.execSQL("create Table NGOAccepted(UserID TEXT, NGOName TEXT, Accepted TEXT)");

        DB.execSQL("create Table Disease(DiseaseName TEXT, Syndrome TEXT, Treatment TEXT)");
        DB.execSQL("insert into Disease(DiseaseName, Syndrome, Treatment) values('Asperger’s Syndrome','•\tProblems making or maintaining friendships\n" +
                "•\tIsolation or minimal interaction in social situations\n" +
                "•\tPoor eye contact or the tendency to stare at others\n" +
                "•\tTrouble interpreting gestures\n" +
                "•\tInability to recognize humor, irony, and sarcasm\n" +
                "•\tInappropriate behaviors or odd mannerisms\n" +
                "•\tProblems expressing empathy, controlling emotions, or communicating feelings\n" +
                "•\tLack of common sense\n" +
                "•\tTendency to engage in one-sided conversations (about oneself)\n" +
                "•\tFascination with certain topics\n" +
                "•\tInterpretation of information as literal\n" +
                "•\tThe preference for a strict schedule or routine\n', '•\tSocial skills training\n" +
                "•\tBehavior supports\n" +
                "•\tCognitive behavioral therapy\n" +
                "•\tParent education and training\n" +
                "•\tSpeech-language therapy\n" +
                "•\tOccupational therapy\n" +
                "•\tSpecial education classes\n" +
                "•\tMedication\n')");
        DB.execSQL("insert into Disease(DiseaseName, Syndrome, Treatment) values('Rett Syndrome','•\tSlowed growth. Brain growth slows after birth.\n" +
                "•\tLoss of normal movement and coordination. \n" +
                "•\tLoss of communication abilities. \n" +
                "•\tAbnormal hand movements. \n" +
                "•\tUnusual eye movements.\n" +
                "•\tBreathing problems.\n" +
                "•\tIrritability and crying.\n" +
                "•\tOther abnormal behaviors.\n','•\tRegular medical care. Management of symptoms and health problems may require a multispecialty team.\n" +
                "•\tMedications. \n" +
                "•\tPhysical therapy. \n" +
                "•\tOccupational therapy. \n" +
                "•\tSpeech-language therapy. \n" +
                "•\tNutritional support.\n" +
                "•\tBehavioral intervention. \n" +
                "•\tSupport services.\n')");
        DB.execSQL("insert into Disease(DiseaseName, Syndrome, Treatment) values('Childhood Disintegrative Disorder(CDD)','•\tExpressive language skills.\n" +
                "•\tReceptive language skills.\n" +
                "•\tSocial skills and self-care skills.\n" +
                "•\tBowel or bladder control.\n" +
                "•\tPlay skills.\n" +
                "•\tMotor skills.\n" +
                "Abnormal function also occurs in at least two of:\n" +
                "•\tSocial interaction.\n" +
                "•\tCommunication.\n" +
                "•\tRepetitive interests or behaviours.\n','•\tBehavior therapy  \n" +
                "•\tEnvironmental Therapy\n" +
                "•\tMedications\n')");
        DB.execSQL("insert into Disease(DiseaseName, Syndrome, Treatment) values('Pervasive Developmental Disorder','o\tUnusual social behavior\n" +
                "o\tImproper development of skills such as motor, sensory, visual-spatial organizational, cognitive, social, academic, and behavioral\n" +
                "o\tCommunication problems\n" +
                "o\tUnderdeveloped speech and language skills\n" +
                "o\tPersistent and repetitive actions such as opening and closing doors repeatedly\n" +
                "o\tAbnormal sensitivity to taste, sight, sound, smell, and/or touch\n','•\tApplied behavioral analysis (ABA). There are several types of ABA. \n" +
                "•\tSpeech or language therapy. \n" +
                "•\tOccupational or physical therapy. \n" +
                "•\tMedications. \n" +
                "•\tCognitive behavioral therapy. \n" +
                "•\tDietary changes. \n" +
                "•\tAlternative or complementary therapies.\n')");
        DB.execSQL("insert into Disease(DiseaseName, Syndrome, Treatment) values('Kanner’s Syndrome','•\tLack of emotional attachment with others.\n" +
                "•\tCommunication and interaction challenges.\n" +
                "•\tUncontrolled speech.\n" +
                "•\tObsession with handling objects.\n" +
                "•\tA high degree of rote memory and visuospatial skills with major difficulties learning in other areas.\n','•\tA spectrum of interventions including behavioral and educational training.\n" +
                "•\tDiet and nutrition, alternative medicine and therapies, and medication should be utilized and finetuned to treat the individual. \n" +
                "•\tThe most strongly recommended treatment option is behavioral and educational \n" +
                "training. Early intervention and treatment is key to helping autistic children grow\n" +
                " into productive adults.\n')");


    }


    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int i1)
    {
        DB.execSQL("drop Table if exists Infomation");
        DB.execSQL("drop Table if exists Schools");
        DB.execSQL("drop Table if exists Doctor");
        DB.execSQL("drop Table if exists NGO");
        DB.execSQL("drop Table if exists NGOMessage");
        DB.execSQL("drop Table if exists NGOAccepted");
        DB.execSQL("drop Table if exists Disease");
        onCreate(DB);
    }


    public Boolean insertdata(String name, String address, String id, String pass, String disease, String blood)
    {
        SQLiteDatabase DB= this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put("Name", name);
        contentValues.put("Address", address);
        contentValues.put("UserID", id);
        contentValues.put("Password", pass);
        contentValues.put("Disease", disease);
        contentValues.put("Blood", blood);
        long result= DB.insert("Infomation",null, contentValues);

        if(result==-1){
            return false;
        }
        else {
            return true;
        }
    }
    public Boolean insertdata1(String name, String address, String id, String rate,String contact,String email, String special, String fee)
    {
        SQLiteDatabase DB= this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put("Name", name);
        contentValues.put("location", address);
        contentValues.put("EIIN", id);
        contentValues.put("Rating", rate);
        contentValues.put("Contact", contact);
        contentValues.put("Email", email);
        contentValues.put("Special", special);
        contentValues.put("fee", fee);
        long result= DB.insert("Schools",null, contentValues);

        if(result==-1){
            return false;
        }
        else {
            return true;
        }
    }
    public Boolean insertdata2(String name, String special, String address, String qua, String hospital, String time )
    {
        SQLiteDatabase DB= this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put("Name", name);
        contentValues.put("Specialised", special);
        contentValues.put("Location", address);
        contentValues.put("qua", qua);
        contentValues.put("hospi", hospital);
        contentValues.put("avai", time);
        long result= DB.insert("Doctor",null, contentValues);

        if(result==-1){
            return false;
        }
        else {
            return true;
        }
    }

    public Boolean checkID(String name){
        SQLiteDatabase DB= this.getWritableDatabase();
        Cursor cursor= DB.rawQuery("Select * from Infomation where UserID= ?", new String[]{name});
        if(cursor.getCount()>0){
            return true;
        }
        else {
            return false;
        }
    }
    public Boolean checkeiin(String name){
        SQLiteDatabase DB= this.getWritableDatabase();
        Cursor cursor= DB.rawQuery("Select * from Schools where EIIN= ?", new String[]{name});
        if(cursor.getCount()>0){
            return true;
        }
        else {
            return false;
        }
    }

    public Boolean checklogin(String name, String password){
        SQLiteDatabase DB= this.getWritableDatabase();
        Cursor cursor= DB.rawQuery("Select * from Infomation where UserID= ? and Password= ?", new String[]{name,password});
        if(cursor.getCount()>0){
            return true;
        }
        else{
            return false;
        }
    }

    public Cursor getinfo(String name){
        SQLiteDatabase DB= this.getWritableDatabase();

        Cursor cursor= DB.rawQuery("Select * from Infomation where UserID=?", new String[]{name});
        return cursor;
    }

    public Cursor getdoctor(){
        SQLiteDatabase DB= this.getWritableDatabase();

        Cursor cursor= DB.rawQuery("Select * from Doctor",null);
        return cursor;
    }
    public boolean checkdoctor(String Specialised1, String Specialised2){
        if(Specialised1.equals(Specialised2)){
            return true;
        }else{
            return false;
        }
    }

    public boolean updatepassword(String id, String password){
        SQLiteDatabase DB= this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put("Password", password);
        Cursor cursor= DB.rawQuery("Select * from Infomation where UserID= ?", new String[]{id});

        if(cursor.getCount()>0){
            long result= DB.update("Infomation", contentValues, "UserID= ? ", new String[]{id});
            if(result==-1){
                return false;
            }
            else {
                return true;
            }
        }
        else {
            return false;
        }

    }

    public boolean updateaccept(String id, String ngoname, String accepted){
        SQLiteDatabase DB= this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put("Accepted", accepted);
        Cursor cursor= DB.rawQuery("Select * from NGOAccepted where UserID=? and NGOName=?",new String[]{id,ngoname});

        if(cursor.getCount()>0){
            long result= DB.update("NGOAccepted",contentValues,"UserID=? and NGOName=?",new String[]{id,ngoname});
            if(result==-1){
                return false;
            }
            else {
                return true;
            }
        }
        else {
            return false;
        }

    }

    public Cursor getestabdate(String name){
        SQLiteDatabase DB= this.getWritableDatabase();
        Cursor cursor= DB.rawQuery("Select * from NGO where Name=?", new String[]{name});
        return cursor;
    }

    public List<School> getAllSchool(String special){
        List<School> SchoolList= new ArrayList<>();
        SQLiteDatabase db= this.getReadableDatabase();

        Cursor cursor= db.rawQuery("select * from Schools where Special=?", new String[]{special});

        if(cursor.moveToFirst()){
            do{
                School school= new School();
                school.setName(cursor.getString(0));
                SchoolList.add(school);
            }while(cursor.moveToNext());
        }
        return SchoolList;
    }

    public Cursor getInfoSpeci(String id){
        SQLiteDatabase DB= this.getWritableDatabase();
        Cursor cursor= DB.rawQuery("select * from Infomation where UserID=?",new String[]{id} );
        return cursor;
    }

    public Cursor getschooldetails(String name){
        SQLiteDatabase DB= this.getWritableDatabase();
        Cursor cursor= DB.rawQuery("select * from Schools where Name=?",new String[]{name} );
        return cursor;
    }

    public List<Doctor> getAllDoctor(String special){
        List<Doctor> DoctorList= new ArrayList<>();
        SQLiteDatabase db= this.getReadableDatabase();

        Cursor cursor= db.rawQuery("select * from Doctor where Specialised=?", new String[]{special});

        if(cursor.moveToFirst()){
            do{
                Doctor doctor= new Doctor();
                doctor.setName(cursor.getString(1));
                DoctorList.add(doctor);
            }while(cursor.moveToNext());
        }
        return DoctorList;
    }

    public Cursor getdoctordetails(String name){
        SQLiteDatabase DB= this.getWritableDatabase();
        Cursor cursor= DB.rawQuery("select * from Doctor where Name=?",new String[]{name} );
        return cursor;
    }

    public Boolean checkIDForNGO(String id, String name){
        SQLiteDatabase DB= this.getWritableDatabase();
        Cursor cursor= DB.rawQuery("Select * from NGOAccepted where UserID= ? and NGOName=?", new String[]{id, name});
        if(cursor.getCount()>0){
            return true;
        }
        else {
            return false;
        }
    }

    public boolean checkyesno(String id, String yesno){
        SQLiteDatabase DB= this.getWritableDatabase();
        Cursor cursor= DB.rawQuery("Select * from NGOAccepted where UserID= ? and Accepted=?", new String[]{id,yesno});
        if(cursor.getCount()>0){
            return true;
        }
        else {
            return false;
        }
    }

    public Boolean deletengo(String id){
        SQLiteDatabase DB= this.getWritableDatabase();

        Cursor cursor= DB.rawQuery("Select * from NGOAccepted where UserID= ? ", new String[]{id});
        if(cursor.getCount()>0){
            long result= DB.delete("NGOMessage",  "UserID= ?", new String[]{id});
            if(result==-1){
                return false;
            }
            else {
                return true;
            }
        }
        else {
            return false;
        }
    }

    public Boolean insertdata3(String id, String NGOName, String PhoneNumber, String Message)
    {
        SQLiteDatabase DB= this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put("UserID", id);
        contentValues.put("NGOName", NGOName);
        contentValues.put("PhoneNumber", PhoneNumber);
        contentValues.put("Message", Message);

        long result= DB.insert("NGOMessage",null, contentValues);

        if(result==-1){
            return false;
        }
        else {
            return true;
        }
    }

    public Boolean insertdata4(String id, String NGOName, String Accepted)
    {
        SQLiteDatabase DB= this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put("UserID", id);
        contentValues.put("NGOName", NGOName);
        contentValues.put("Accepted", Accepted);

        long result= DB.insert("NGOAccepted",null, contentValues);

        if(result==-1){
            return false;
        }
        else {
            return true;
        }
    }

    public List<Ngomodel> getAllNgomodel(String ngo){
        List<Ngomodel> NgomodelList= new ArrayList<>();
        SQLiteDatabase db= this.getReadableDatabase();

        Cursor cursor= db.rawQuery("select * from NGOMessage where NGOName=?", new String[]{ngo});

        if(cursor.moveToFirst()){
            do{
                Ngomodel ngomodel= new Ngomodel();
                ngomodel.setUserID(cursor.getString(0));
                NgomodelList.add(ngomodel);
            }while(cursor.moveToNext());
        }
        return NgomodelList;
    }

    public Cursor getreqngo(String id, String ngo){
        SQLiteDatabase DB= this.getWritableDatabase();

        Cursor cursor= DB.rawQuery("Select * from NGOMessage where UserID=? and NGOName=?",new String[]{id,ngo});
        return cursor;
    }

    public boolean checkacceptedornot(String id){
        SQLiteDatabase DB= this.getWritableDatabase();
        String yes= "YES";
        Cursor cursor= DB.rawQuery("Select * from NGOAccepted where UserID= ? and Accepted=?", new String[]{id,yes});
        if(cursor.getCount()>0){
            return true;
        }
        else{
            return false;
        }

    }

    public boolean checkrequestornot(String id){
        SQLiteDatabase DB= this.getWritableDatabase();
        Cursor cursor= DB.rawQuery("Select * from NGOAccepted where UserID=?",new String[]{id});
        if(cursor.getCount()>0){
            return true;
        }
        else{
            return false;
        }
    }

    public Cursor getoverview(String disease){
        SQLiteDatabase DB= this.getWritableDatabase();
        Cursor cursor= DB.rawQuery("Select * from Disease where DiseaseName=? ",new String[]{disease});
        return cursor;
    }

    public Cursor getngoname(String id){
        SQLiteDatabase DB= this.getWritableDatabase();
        String yes= "YES";
        Cursor cursor= DB.rawQuery("Select * from NGOAccepted where UserID= ? and Accepted=?", new String[]{id,yes});
        return cursor;
    }


}