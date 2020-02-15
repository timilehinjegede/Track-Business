package com.timilehinjegede.track_business.Fragments;


import android.os.Bundle;

import androidx.appcompat.widget.PopupMenu;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.timilehinjegede.track_business.Adapter.InventoryAdapter;
import com.timilehinjegede.track_business.Dialogs.AdddProductDialog;
import com.timilehinjegede.track_business.R;
import com.timilehinjegede.track_business.ViewModel.ProductViewModel;

/**
 * A simple {@link Fragment} subclass.
 */
public class InventoryFragment extends Fragment {


    public InventoryFragment() {
        // Required empty public constructor
    }

    View view;
    RecyclerView allInventoryRecyclerView;
    InventoryAdapter inventoryAdapter;
    ProductViewModel productViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_inventory, container, false);

        FloatingActionButton floatingActionButton = view.findViewById(R.id.addProductFab);
        allInventoryRecyclerView = view.findViewById(R.id.allInventoryRecyclerView);



        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                PopupMenu popupMenu = new PopupMenu(getActivity().getApplicationContext(),view);
//                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
//                    @Override
//                    public boolean onMenuItemClick(MenuItem item) {
//                        switch (item.getItemId()){
//                            case R.id.viewPurchases:
//                                Toast.makeText(getContext(),"View Purchases",Toast.LENGTH_SHORT).show();
//                                return true;
//                            case R.id.viewSales:
//                                Toast.makeText(getContext(),"View sales",Toast.LENGTH_SHORT).show();
//                                return true;
//                        }
//                        return false;
//                    }
//                });
//                popupMenu.inflate(R.menu.popup_menu);
//                popupMenu.show();

                productViewModel = ViewModelProviders.of(getTargetFragment()).get(ProductViewModel.class);

                AdddProductDialog productDialog = new AdddProductDialog();
                productDialog.show(getFragmentManager(),"addproduct");
            }
        });

        return view;
    }

}
