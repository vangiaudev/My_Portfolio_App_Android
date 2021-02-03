package vangiaurecca.example.myportfolioapplication.sidemenu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import vangiaurecca.example.myportfolioapplication.R;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.MenuViewHolder> {

    List<MenuItem> mdata;
    Callback listener;

    public MenuAdapter(List<MenuItem> mdata, Callback listener) {
        this.mdata = mdata;
        this.listener = listener;
    }

    @NonNull
    @Override
    public MenuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_menu,parent, false);

        return new MenuViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MenuViewHolder holder, int position) {

        holder.icon.setImageResource(mdata.get(position).getIcon());
        if(mdata.get(position).isSelected()) {
            holder.isSelected.setVisibility(View.VISIBLE);
        }
        else {
            holder.isSelected.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return mdata.size();
    }

    public class MenuViewHolder extends RecyclerView.ViewHolder{

        ImageView icon, isSelected;
        public MenuViewHolder(@NonNull View itemView) {
            super(itemView);

            icon = itemView.findViewById(R.id.imgItemMenuIcon);
            isSelected = itemView.findViewById(R.id.imgItemMenuSelected);

            //menu item click
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onSideMenuItemClick(getAdapterPosition());
                }
            });

        }
    }
}
