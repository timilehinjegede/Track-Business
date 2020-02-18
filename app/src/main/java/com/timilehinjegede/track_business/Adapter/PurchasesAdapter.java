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

import java.util.ArrayList;
import java.util.List;

public class PurchasesAdapter extends RecyclerView.Adapter<PurchasesAdapter.PurchaseOrSalesHolder> {

    public List<PurchasesHistory> productHistoryList = new ArrayList<>();
    private Context context;
    private onPurchaseClickListener listener;

    public PurchasesAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public PurchaseOrSalesHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.producthistory_item,
                parent,
                false
        );

        return new PurchaseOrSalesHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PurchaseOrSalesHolder holder, int position) {
        PurchasesHistory productHistory = productHistoryList.get(position);

        holder.pNameTV.setText(productHistory.getName());

        String quantity = String.valueOf(productHistory.getQuantityPurchased());
        String quantityType = String.valueOf(productHistory.getQuantityType());

        holder.pQuantityTV.setText(quantity+""+quantityType);
        holder.pPSTV.setText(productHistory.getPurchasedFrom());
    }

    @Override
    public int getItemCount() {
        return productHistoryList.size();
    }

    public void setProductHistoryList(List<PurchasesHistory> productHistoryList){
        this.productHistoryList = productHistoryList;
        notifyDataSetChanged();
    }

    public void setOnPurchaseClickListener(onPurchaseClickListener listener){
        this.listener = listener;
    }

    class PurchaseOrSalesHolder extends RecyclerView.ViewHolder{

        TextView pNameTV , pQuantityTV , pPSTV ;

        public PurchaseOrSalesHolder(@NonNull View itemView) {
            super(itemView);

            pNameTV = itemView.findViewById(R.id.pNameTV);
            pQuantityTV = itemView.findViewById(R.id.pQuantityTV);
            pPSTV = itemView.findViewById(R.id.pPSNameTV);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    listener.onPurchaseHistoryClicked(productHistoryList.get(position));
                }
            });
        }
    }

    public interface onPurchaseClickListener{
        void onPurchaseHistoryClicked(PurchasesHistory purchasesHistory);
    }
}
