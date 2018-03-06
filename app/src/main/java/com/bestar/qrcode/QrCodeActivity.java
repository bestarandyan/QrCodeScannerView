package com.bestar.qrcode;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.bestar.qrcode.qrcode.OnScannerCompletionListener;
import com.bestar.qrcode.qrcode.ScannerView;
import com.google.zxing.Result;
import com.google.zxing.client.result.ParsedResult;

public class QrCodeActivity extends AppCompatActivity implements View.OnClickListener, OnScannerCompletionListener {
    private ScannerView mScannerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qr_code);
        mScannerView = findViewById(R.id.scanner_view);
        mScannerView.setOnScannerCompletionListener(this);
        mScannerView.setLaserFrameBoundColor(Color.WHITE);
        mScannerView.setLaserGridLineResId(R.mipmap.zfb_grid_scan_line);
        mScannerView.setLaserFrameCornerLength(30);
        mScannerView.setLaserFrameCornerWidth(3);
    }

    @Override
    public void onResume() {
        super.onResume();
        onResumeScannerView();
    }

    @Override
    public void onPause() {
        mScannerView.onPause();
        super.onPause();
    }

    @Override
    public void onClick(View view) {

    }

    @Override
    public void OnScannerCompletion(Result rawResult, ParsedResult parsedResult, Bitmap barcode) {

    }

    private void onResumeScannerView() {
        try {
            mScannerView.onResume();
        } catch (Exception ex) {
            ex.printStackTrace();
            Toast.makeText(this, "调用相机异常，请检查是否授权！", Toast.LENGTH_SHORT).show();
            this.finish();
        }
    }

}
