package com.straighttalk.ui;

import android.app.Dialog;
import android.os.Build;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import com.straighttalk.R;
import com.straighttalk.dto.MessageCustomDialogDTO;

/**
 * Created by Harsh on 8/6/2016.
 */
public class MessageDialog {

    private MessageCustomDialogDTO messageCustomDialogDTO;

    public MessageDialog(MessageCustomDialogDTO messageCustomDialogDTO) {
        this.messageCustomDialogDTO = messageCustomDialogDTO;
    }

    public void warning() {
        final Dialog dialog = new Dialog(messageCustomDialogDTO.getContext());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.custom_dialog_message);
        TextView text = (TextView) dialog.findViewById(R.id.txtDialogMessageTitle);
        text.setText(messageCustomDialogDTO.getTitle());
        text = (TextView) dialog.findViewById(R.id.txtDialogMessageMessage);
        text.setText(messageCustomDialogDTO.getMessage());
        Button yes = (Button) dialog.findViewById(R.id.btnDismissDialogMessage);
        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    public void error() {
        final Dialog dialog = new Dialog(messageCustomDialogDTO.getContext());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.custom_dialog_message);
        TextView text = (TextView) dialog.findViewById(R.id.txtDialogMessageTitle);
        text.setText(messageCustomDialogDTO.getTitle());
        text = (TextView) dialog.findViewById(R.id.txtDialogMessageMessage);
        text.setText(messageCustomDialogDTO.getMessage());
        Button yes = (Button) dialog.findViewById(R.id.btnDismissDialogMessage);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            yes.setBackgroundResource(R.drawable.ripple);
        }
        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    public void success() {
        final Dialog dialog = new Dialog(messageCustomDialogDTO.getContext());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.custom_dialog_message);
        TextView text = (TextView) dialog.findViewById(R.id.txtDialogMessageTitle);
        text.setText(messageCustomDialogDTO.getTitle());
        text = (TextView) dialog.findViewById(R.id.txtDialogMessageMessage);
        text.setText(messageCustomDialogDTO.getMessage());
        Button yes = (Button) dialog.findViewById(R.id.btnDismissDialogMessage);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            yes.setBackgroundResource(R.drawable.ripple);
        }
        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    public void showNonCancellable(){
        final Dialog dialog = new Dialog(messageCustomDialogDTO.getContext());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.custom_dialog_message);
        TextView text = (TextView) dialog.findViewById(R.id.txtDialogMessageTitle);
        text.setText(messageCustomDialogDTO.getTitle());
        text = (TextView) dialog.findViewById(R.id.txtDialogMessageMessage);
        text.setText(messageCustomDialogDTO.getMessage());
        Button yes = (Button) dialog.findViewById(R.id.btnDismissDialogMessage);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            yes.setBackgroundResource(R.drawable.ripple);
        }
        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.setCancelable(false);
        dialog.show();
    }

}
