package np.com.dineshbishwakarma.shreeganeshsuppliersinventory.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import np.com.dineshbishwakarma.shreeganeshsuppliersinventory.CustomerDetails;
import np.com.dineshbishwakarma.shreeganeshsuppliersinventory.R;


public class HomeFragment extends Fragment implements View.OnClickListener {

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
        buttonPurchaseEntry.setOnClickListener(this);




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
        Intent intent = new Intent(getActivity(), CustomerDetails.class);
        startActivity(intent);
    }
}