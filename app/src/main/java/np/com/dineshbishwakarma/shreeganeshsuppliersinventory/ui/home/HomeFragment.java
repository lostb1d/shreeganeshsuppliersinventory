package np.com.dineshbishwakarma.shreeganeshsuppliersinventory.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import np.com.dineshbishwakarma.shreeganeshsuppliersinventory.BackUp;
import np.com.dineshbishwakarma.shreeganeshsuppliersinventory.Calculator;
import np.com.dineshbishwakarma.shreeganeshsuppliersinventory.CustomerDetails;
import np.com.dineshbishwakarma.shreeganeshsuppliersinventory.ExpensesList;
import np.com.dineshbishwakarma.shreeganeshsuppliersinventory.ProductList;
import np.com.dineshbishwakarma.shreeganeshsuppliersinventory.PurchaseOrder;
import np.com.dineshbishwakarma.shreeganeshsuppliersinventory.Purchase_Entry;
import np.com.dineshbishwakarma.shreeganeshsuppliersinventory.R;
import np.com.dineshbishwakarma.shreeganeshsuppliersinventory.SalesOrder;
import np.com.dineshbishwakarma.shreeganeshsuppliersinventory.SellEntry;
import np.com.dineshbishwakarma.shreeganeshsuppliersinventory.StocksOnHand;
import np.com.dineshbishwakarma.shreeganeshsuppliersinventory.VendorDetail;


public class HomeFragment extends Fragment implements View.OnClickListener {
    protected static final String TAG = "HomeFragment";
    private HomeViewModel homeViewModel;
    private TextView dateTimeDisplay;
    private Calendar calendar;
    private SimpleDateFormat dateFormat;
    private String date;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        dateTimeDisplay = (TextView) root.findViewById((R.id.dateTimeDisplay));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        date = sdf.format(new Date());
        dateTimeDisplay.setText(date);

        Button buttonPurchaseEntry = (Button) root.findViewById(R.id.buttonPurchaseEntry);
        Button buttonSell = (Button) root.findViewById(R.id.buttonSell);
        Button buttonProductList = (Button) root.findViewById(R.id.buttonProductList);
        Button buttonStockOnHands = (Button) root.findViewById(R.id.buttonStocksOnHand);
        Button buttonVendorDetails = (Button) root.findViewById(R.id.buttonVendorDetail);
        Button buttonCustomerDetails = (Button) root.findViewById(R.id.buttonCustomerDetails);
        Button buttonPurchaseOrder = (Button) root.findViewById(R.id.buttonPurchaseOrder);
        Button buttonSalesOrder = (Button) root.findViewById(R.id.buttonSalesOrder);
        Button buttonExpenseList = (Button) root.findViewById(R.id.buttonExpenseList);
        Button buttonCalculator = (Button) root.findViewById(R.id.buttonCalculator);
        Button buttonBackup = (Button) root.findViewById(R.id.buttonBackUp);


        buttonPurchaseEntry.setOnClickListener(this);
        buttonSell.setOnClickListener(this);
        buttonProductList.setOnClickListener(this);
        buttonStockOnHands.setOnClickListener(this);
        buttonVendorDetails.setOnClickListener(this);
        buttonCustomerDetails.setOnClickListener(this);
        buttonPurchaseOrder.setOnClickListener(this);
        buttonSalesOrder.setOnClickListener(this);
        buttonExpenseList.setOnClickListener(this);
        buttonCalculator.setOnClickListener(this);
        buttonBackup.setOnClickListener(this);


//        final TextView textView = root.findViewById(R.id.text_home);
//        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });
        return root;
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (v.getId()) {
            case R.id.buttonPurchaseEntry:
                startActivity(new Intent(getActivity(), Purchase_Entry.class));
                break;
            case R.id.buttonSell:
                startActivity(new Intent(getActivity(), SellEntry.class));
                break;
            case R.id.buttonProductList:
                startActivity(new Intent(getActivity(), ProductList.class));
                break;
            case R.id.buttonStocksOnHand:
                startActivity(new Intent(getActivity(), StocksOnHand.class));
                break;
            case R.id.buttonVendorDetail:
                startActivity(new Intent(getActivity(), VendorDetail.class));
                break;
            case R.id.buttonCustomerDetails:
                startActivity(new Intent(getActivity(), CustomerDetails.class));
                break;
            case R.id.buttonPurchaseOrder:
                startActivity(new Intent(getActivity(), PurchaseOrder.class));
                break;
            case R.id.buttonSalesOrder:
                startActivity(new Intent(getActivity(), SalesOrder.class));
                break;
            case R.id.buttonExpenseList:
                startActivity(new Intent(getActivity(), ExpensesList.class));
                break;
            case R.id.buttonCalculator:
                startActivity(new Intent(getActivity(), Calculator.class));
                break;
            case R.id.buttonBackUp:
                startActivity(new Intent(getActivity(), BackUp.class));
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + v.getId());
        }

    }
}