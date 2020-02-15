package com.timilehinjegede.track_business.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.PopupMenu;
import androidx.recyclerview.widget.RecyclerView;

import com.timilehinjegede.track_business.R;
import com.timilehinjegede.track_business.db.Product;

import java.util.ArrayList;
import java.util.List;

public class InventoryAdapter extends RecyclerView.Adapter<InventoryAdapter.InventoryViewHolder> {

    public List<Product> productList = new ArrayList<>();
    public onProductClickListener onProductClickListener;
    private Context context;
    String viewFilterSelected;
    public onProductLongClickListener onProductLongClickListener;


    public InventoryAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public InventoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.product_item,
                parent,
                false
        );

        return new InventoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull InventoryViewHolder holder, int position) {

        Product currentProduct = productList.get(position);
        holder.nameOfProduct.setText(currentProduct.getName());

        String quantity = String.valueOf(currentProduct.getQuantity());
        String unitPrice = String.valueOf(currentProduct.getUnitPrice());

        holder.quantityOfProduct.setText(quantity);
        holder.unitPriceOfProduct.setText(unitPrice);
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    public void setOnProductClickListener(onProductClickListener onProductClickListener){
        this.onProductClickListener = onProductClickListener;
    }

    public void setOnProductLongClickListener(onProductLongClickListener onProductLongClickListener){
        this.onProductLongClickListener = onProductLongClickListener;
    }

    public void setProductList(List<Product> productList){
        this.productList = productList;
        notifyDataSetChanged();
    }

    public Product getProduct(int position){
        return productList.get(position);
    }

    class InventoryViewHolder extends RecyclerView.ViewHolder {

        TextView nameOfProduct, quantityOfProduct, unitPriceOfProduct;

        public InventoryViewHolder(@NonNull View itemView) {
            super(itemView);

            nameOfProduct = itemView.findViewById(R.id.productNameTextView);
            quantityOfProduct = itemView.findViewById(R.id.productQuantityTextView);
            unitPriceOfProduct = itemView.findViewById(R.id.productUnitPriceTextView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    PopupMenu popupMenu = new PopupMenu(context,view);
                    popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                        @Override
                        public boolean onMenuItemClick(MenuItem item) {
                            switch (item.getItemId()){
                                case R.id.viewPurchases:
                                    viewFilterSelected = "purchases";
                                    int position = getAdapterPosition();
                                    onProductClickListener.onProductClicked(productList.get(position),viewFilterSelected);
//                                viewPurchases();
//                                    Toast.makeText(context,"View Purchases",Toast.LENGTH_SHORT).show();
                                    return true;
                                case R.id.viewSales:
//                                viewSales();
                                    viewFilterSelected = "sales";
                                    position = getAdapterPosition();
                                    onProductClickListener.onProductClicked(productList.get(position),viewFilterSelected);
//                                    Toast.makeText(context,"View sales",Toast.LENGTH_SHORT).show();
                                    return true;
                            }
                            return false;
                        }
                    });
                    popupMenu.inflate(R.menu.popup_menu);
                    popupMenu.show();


                }
            });

            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {

                    int thePosition = getAdapterPosition();
                    onProductLongClickListener.onProductLongClicked(productList.get(thePosition));
                    return false;
                }
            });
        }
    }

    public interface  onProductClickListener{
        void onProductClicked(Product product,String viewFilter);
    }

    public interface  onProductLongClickListener{
        void onProductLongClicked(Product product);
    }
}
