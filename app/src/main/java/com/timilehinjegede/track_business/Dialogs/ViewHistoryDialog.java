package com.timilehinjegede.track_business.Dialogs;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;

import com.timilehinjegede.track_business.R;

public class ViewHistoryDialog extends AppCompatDialogFragment {

    TextView name , quantity , unitPrice , discount , totalPrice, sOrp, date, time, title ;
    String mName, mQuantity, mQuantityType, mUnitPrice, mDiscount, mTotalPrice, msOrp, mDate, mTime, mTitle;
    ImageView closeDialog;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.purchasehistorydetail,null);

        name = view.findViewById(R.id.viewOrder_name);
        quantity = view.findViewById(R.id.viewOrder_quantity);
        unitPrice = view.findViewById(R.id.viewOrder_unitprice);
        discount = view.findViewById(R.id.viewOrder_discount);
        totalPrice = view.findViewById(R.id.viewOrder_totalprice);
        sOrp = view.findViewById(R.id.viewOrder_SorP);
        date = view.findViewById(R.id.viewOrder_date);
        time = view.findViewById(R.id.viewOrder_time);
        title = view.findViewById(R.id.theTitle);
        closeDialog = view.findViewById(R.id.closeDialog);

        closeDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),"Touch the screen to close",Toast.LENGTH_LONG).show();
            }
        });

        populateDetails();

        builder.setView(view);
        return builder.create();
    }

    public ViewHistoryDialog(String mName, String mQuantity, String mQuantityType, String mUnitPrice, String mDiscount, String mTotalPrice, String msOrp, String mDate, String mTime, String mTitle) {
        this.mName = mName;
        this.mQuantity = mQuantity;
        this.mQuantityType = mQuantityType;
        this.mUnitPrice = mUnitPrice;
        this.mDiscount = mDiscount;
        this.mTotalPrice = mTotalPrice;
        this.msOrp = msOrp;
        this.mDate = mDate;
        this.mTime = mTime;
        this.mTitle = mTitle;
    }

    public void populateDetails(){
        name.setText(mName);
        quantity.setText(mQuantity);
        unitPrice.setText(mUnitPrice);
        discount.setText(mDiscount);
        totalPrice.setText(mTotalPrice);
        sOrp.setText(msOrp);
        date.setText(mDate);
        time.setText(mTime);
        title.setText(mTitle);
    }

}
