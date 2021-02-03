package vangiaurecca.example.myportfolioapplication.cv;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import vangiaurecca.example.myportfolioapplication.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CVFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CVFragment extends Fragment {

    RecyclerView rvCV;
    CVAdapter adapter;
    List<CVItem> items;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rvCV = view.findViewById(R.id.rvCV);

        items = new ArrayList<>();
        items.add(new CVItem("August 2016 - June 2019", "Studied at Cho Gao Senior High School\nAcademic Achievement: Certificate of High School Graduation"));
        items.add(new CVItem("August 2019 - Present", "Studying at HoChiMinh University of Pedagogy\nSpecialized: Software Engineering"));
        items.add(new CVItem("January 2020 - Present", "Gain experience and programming thinking from seniors as well as colleagues in the HCMUE house"));
        items.add(new CVItem("Present", getString(R.string.current_job)));

        adapter = new CVAdapter(items);
        rvCV.setLayoutManager(new LinearLayoutManager(getContext()));
        rvCV.setAdapter(adapter);

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_c_v, container, false);
    }
}