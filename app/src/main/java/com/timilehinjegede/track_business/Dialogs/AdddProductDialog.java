package com.timilehinjegede.track_business.Dialogs;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;

import com.timilehinjegede.track_business.R;

public class AdddProductDialog extends AppCompatDialogFragment {

    String nameOfProduct , unitPriceOfProduct , quantityOfProduct , quantityTypeOfProduct;
    private addProductListener productListener;

    EditText name , quantity , unitPrice , quantityType ;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater layoutInflater = getActivity().getLayoutInflater();
        View view = layoutInflater.inflate(R.layout.add_product,null);


        name = view.findViewById(R.id.nameOfProduct);
        quantity = view.findViewById(R.id.quantityOfProduct);
//        quantityType = view.findViewById(R.id.quantityTypeOfProduct);
        unitPrice = view.findViewById(R.id.unitPriceOfProduct);

        builder.setView(view)
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                .setPositiveButton("Add Product", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        nameOfProduct = name.getText().toString().toUpperCase().trim();
                        quantityOfProduct = quantity.getText().toString().toUpperCase().trim();
                        unitPriceOfProduct = unitPrice.getText().toString().toUpperCase().trim();
//                        quantityTypeOfProduct = quantityType.getText().toString().toUpperCase().trim();
                        String quantityType = "pieces";
                        productListener.addProduct(nameOfProduct,quantityOfProduct,unitPriceOfProduct,quantityType);
                    }
                });

        return builder.create();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        productListener = (addProductListener)context;
    }

    public interface  addProductListener{
        void addProduct(String name, String quantity, String unitPrice, String quantityType);
    }
}
