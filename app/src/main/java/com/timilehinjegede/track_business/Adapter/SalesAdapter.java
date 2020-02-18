package com.timilehinjegede.track_business.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.timilehinjegede.track_business.R;
import com.timilehinjegede.track_business.db.PurchasesHistory;
import com.timilehinjegede.track_business.db.SalesHistory;

import java.util.ArrayList;
import java.util.List;

public class SalesAdapter extends RecyclerView.Adapter<SalesAdapter.SalesHolder> {

    public List<SalesHistory> salesHistories = new ArrayList<>();
    private Context context;
    private onSalesHistoryListener listener;

    public SalesAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public SalesHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.producthistory_item,
                parent,
                false
        );

        return new SalesHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SalesHolder holder, int position) {
        SalesHistory salesHistory = salesHistories.get(position);

        holder.pNameTV.setText(salesHistory.getName());

        String quantity = String.valueOf(salesHistory.getSoldTo());
        String quantityType = String.valueOf(salesHistory.getQuantityType());

        holder.pQuantityTV.setText(quantity+""+quantityType);
        holder.pPSTV.setText(salesHistory.getSoldTo());
    }

    @Override
    public int getItemCount() {
        return salesHistories.size();
    }

    public void setSalesHistories(List<SalesHistory> salesHistories){
        this.salesHistories = salesHistories;
        notifyDataSetChanged();
    }

    public void setOnSalesHistoryListener(onSalesHistoryListener listener){
        this.listener = listener;
    }

    class SalesHolder extends RecyclerView.ViewHolder{

        TextView pNameTV , pQuantityTV , pPSTV ;

        public SalesHolder(@NonNull View itemView) {
            super(itemView);

            pNameTV = itemView.findViewById(R.id.pNameTV);
            pQuantityTV = itemView.findViewById(R.id.pQuantityTV);
            pPSTV = itemView.findViewById(R.id.pPSNameTV);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    listener.onSalesHistoryClicked(salesHistories.get(position));
                }
            });
        }
    }

    public interface onSalesHistoryListener{
        void onSalesHistoryClicked(SalesHistory salesHistory);
    }
}
