package steveburns.me.builditbigger;

import android.content.Context;
import android.view.View;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

/**
 * Created by sburns on 12/12/15.
 */
public class AdManager {

    InterstitialAd mInterstitialAd;
    AdInterface mAdInterface;

    /**
     * constructor.
     * @param context - context
     * @param view - view
     * @param adInterfaceClass - interface back to caller
     */
    public AdManager(final Context context, final View view, final AdInterface adInterfaceClass) {

        mAdInterface = adInterfaceClass;
        mInterstitialAd = new InterstitialAd(context);
        mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");

        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                requestNewInterstitial();
                mAdInterface.notifyAdFinished();
            }
        });

        requestNewInterstitial();
        insertAds(view);
    }

    /**
     * showAd
     */
    public void showAd() {
        if (mInterstitialAd != null && mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        }
    }

    private void insertAds(final View root) {

        final AdView mAdView = (AdView) root.findViewById(R.id.adView);
        if (mAdView != null) {
            // Create an ad request. Check logcat output for the hashed device ID to
            // get test ads on a physical device. e.g.
            // "Use AdRequest.Builder.addTestDevice("ABCDEF012345") to get test ads on this device."
            final AdRequest adRequest = new AdRequest.Builder()
                    .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                    .build();
            mAdView.loadAd(adRequest);
        }
    }

    private void requestNewInterstitial() {
        final AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();

        mInterstitialAd.loadAd(adRequest);
    }
}
