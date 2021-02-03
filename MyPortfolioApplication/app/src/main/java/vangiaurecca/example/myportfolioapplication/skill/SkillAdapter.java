package vangiaurecca.example.myportfolioapplication.skill;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import vangiaurecca.example.myportfolioapplication.R;

public class SkillAdapter extends RecyclerView.Adapter<SkillAdapter.SkillViewHolder> {
    List<SkillItem> mdata;

    public SkillAdapter(List<SkillItem> mdata) {
        this.mdata = mdata;
    }

    @NonNull
    @Override
    public SkillViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_skill,parent, false);

        return new SkillViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SkillViewHolder holder, int position) {
        holder.txtName.setText(mdata.get(position).getName());
        holder.txtDesc.setText(mdata.get(position).getDesc());
        holder.imgSkill.setImageResource(mdata.get(position).getImg());
    }

    @Override
    public int getItemCount() {
        return mdata.size();
    }

    public  class SkillViewHolder extends RecyclerView.ViewHolder{

        TextView txtName, txtDesc;
        ImageView imgSkill;
        public SkillViewHolder(@NonNull View itemView) {
            super(itemView);

            txtName   = itemView.findViewById(R.id.txtSkillItemName);
            txtDesc   = itemView.findViewById(R.id.txtSkillItemDesc);
            imgSkill  = itemView.findViewById(R.id.imgSkillItem);
        }
    }
}
