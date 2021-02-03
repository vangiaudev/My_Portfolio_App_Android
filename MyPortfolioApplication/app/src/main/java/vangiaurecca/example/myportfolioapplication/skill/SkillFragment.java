package vangiaurecca.example.myportfolioapplication.skill;

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
 * Use the {@link SkillFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SkillFragment extends Fragment {

    RecyclerView rvSkill;
    SkillAdapter adapter;
    List<SkillItem> mdata;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_skill, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rvSkill = view.findViewById(R.id.rvSkill);

        //create list of skill item
        SkillItem item = new SkillItem("Java", "Write Android apps\nLevel: 40%", R.drawable.logo_java);
        SkillItem item2 = new SkillItem("C#", "Manipulate the database\nLevel: 40%", R.drawable.logo_csharp);
        SkillItem item3 = new SkillItem("C++", "Build a foundation for learning to code\nLevel: 70%", R.drawable.logo_cplusplus);
        SkillItem item4 = new SkillItem("HTML", "Front-end development\nLevel: 30%", R.drawable.logo_html);
        SkillItem item5 = new SkillItem("CSS", "Design website interface\nLevel: 30%", R.drawable.logo_css);
        SkillItem item6 = new SkillItem("Java Script", "Cross-platform programming\nLevel: 20%", R.drawable.logo_javascript);
        SkillItem item7 = new SkillItem("Photoshop", "Designer\nLevel: 25%", R.drawable.logo_photoshop);



        mdata = new ArrayList<>();
        mdata.add(item);
        mdata.add(item2);
        mdata.add(item3);
        mdata.add(item4);
        mdata.add(item5);
        mdata.add(item6);
        mdata.add(item7);

        //setup Adapter and RecyclerView
        rvSkill.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new SkillAdapter(mdata);
        rvSkill.setAdapter(adapter);


    }
}