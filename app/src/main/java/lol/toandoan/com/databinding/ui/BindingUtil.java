package lol.toandoan.com.databinding.ui;

import android.databinding.BindingAdapter;
import android.databinding.InverseBindingAdapter;
import android.databinding.InverseBindingListener;
import android.support.v7.widget.AppCompatSpinner;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

/**
 * Created by framgia on 22/03/2017.
 */
public class BindingUtil {
    @BindingAdapter("adapter")
    public static void setAdapter(AppCompatSpinner spinner, ArrayAdapter adapter) {
        spinner.setAdapter(adapter);
    }

    @InverseBindingAdapter(attribute = "selection", event = "selectionAttrChanged")
    public static String getSelectedValue(AdapterView view) {
        return (String) view.getSelectedItem();
    }

    @BindingAdapter(value = {"selection", "selectionAttrChanged", "adapter"}, requireAll = false)
    public static void setAdapter(AdapterView view, String newSelection,
                                  final InverseBindingListener bindingListener,
                                  ArrayAdapter adapter) {
        view.setAdapter(adapter);
        view.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                bindingListener.onChange();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                //Nothing
            }
        });
        if (newSelection != null) {
            int pos = ((ArrayAdapter) view.getAdapter()).getPosition(newSelection);
            view.setSelection(pos);
        }
    }
}
