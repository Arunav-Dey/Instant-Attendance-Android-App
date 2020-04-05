package com.deysofts.portalboy;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class FirebaseDatabaseHelper {

    public interface DataStatus
    {
        void DataIsLoaded(List<helper> help,List<String> keys);
        void DataIsInserted();
        void DataIsUpdated();
        void DataIsDeleted();


    }

    private FirebaseDatabase mDatabase;
    private DatabaseReference mReference;
    private List<helper> help =new ArrayList<>();

    public FirebaseDatabaseHelper() {
        mDatabase=FirebaseDatabase.getInstance();
        mReference=mDatabase.getReference("BT");

    }

    public void readData(final DataStatus dataStatus)
    {
        mReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                help.clear();
                List<String> keys=new ArrayList<>();
                for (DataSnapshot keyNode : dataSnapshot.getChildren())
                {
                    keys.add(keyNode.getKey());
                    helper hello=keyNode.getValue(helper.class);
                    help.add(hello);

                }
                dataStatus.DataIsLoaded(help,keys);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
