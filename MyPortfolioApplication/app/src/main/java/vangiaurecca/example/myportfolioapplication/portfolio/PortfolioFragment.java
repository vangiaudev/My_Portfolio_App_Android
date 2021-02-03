package vangiaurecca.example.myportfolioapplication.portfolio;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import vangiaurecca.example.myportfolioapplication.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PortfolioFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PortfolioFragment extends Fragment implements PortfolioCallback{

    List<PortfolioItem> mdata;
    RecyclerView rvPortfolio;
    PortfolioAdapter portfolioAdapter;


    public PortfolioFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_portfolio, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rvPortfolio = view.findViewById(R.id.rvPortfolio);

        //create a list of portfolio item
        mdata = new ArrayList<>();

        mdata.add(new PortfolioItem((R.drawable.project_winform), "Student Management", "Language: C# (80%), SQL (20%)\nThe project is written in the C# programming language in conjunction with the use of SQL database"));
        mdata.add(new PortfolioItem((R.drawable.project_blog), "Personal Blog", "Language: HTML (85%), CSS (15%)\n A portfolio is designed on website platform"));
        mdata.add(new PortfolioItem((R.drawable.project_game_animal), "Game Racing Animal", "Language: Java (100%)\nRacing Animal is based on the game Animal Crossing, but has removed some parts to make the game lighter"));
        mdata.add(new PortfolioItem((R.drawable.project_mc), "Website Manchester City Demo", "Language: HTML (60%), CSS (40%)\nDesign a website part according to Manchester City is interface\""));
        mdata.add(new PortfolioItem((R.drawable.project_graph_theory), "Employees Management", "Language: C++ (100%)\nDemo some Graph Theory algorithm such as Dijkstra, Ford-Bellman, Hamilton, Euler etc. Using WINBGI graphics"));
        mdata.add(new PortfolioItem((R.drawable.project_shopee), "Website Shopee Demo", "Language: HTML (40%), CSS (40%), Javascript (20%)\nDesign a website part according to Shopee's interface"));

        portfolioAdapter = new PortfolioAdapter(mdata, this);

        //setup grid RecycleView
        rvPortfolio.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        rvPortfolio.setAdapter(portfolioAdapter);

    }

    @Override
    public void onPortfolioItemClick(int pos) {

        PortfolioFragmentDetails portfolioFragmentDetails = new PortfolioFragmentDetails();
        Bundle bundle = new Bundle();
        bundle.putSerializable("object", mdata.get(pos));
        portfolioFragmentDetails.setArguments(bundle);

        portfolioFragmentDetails.show(getActivity().getSupportFragmentManager(), "tagname");


    }
}