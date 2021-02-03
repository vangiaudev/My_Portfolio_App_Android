package vangiaurecca.example.myportfolioapplication.portfolio;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import vangiaurecca.example.myportfolioapplication.R;


public class PortfolioFragmentDetails extends BottomSheetDialogFragment {

    private ImageView imgPortfolio;
    private TextView txtTitle, txtDesc;

    public PortfolioFragmentDetails() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_portfolio_details, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        imgPortfolio = view.findViewById(R.id.imgPortfolioDetails);
        txtTitle     = view.findViewById(R.id.txtPortfolioTitle);
        txtDesc      = view.findViewById(R.id.txtPortfolioDesc);

        Bundle bundle = getArguments();
        assert bundle != null;
        PortfolioItem item = (PortfolioItem) bundle.getSerializable("object");
        loadPortfolioData(item);
    }

    void loadPortfolioData(PortfolioItem item){
        Glide.with(getContext()).load(item.getImage()).into(imgPortfolio);
        txtTitle.setText(item.getTitle());
        txtDesc.setText(item.getDescription());

    }
}