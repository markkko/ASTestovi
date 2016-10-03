package markko.testoviassprint;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import markko.testoviassprint.Pitanja.Pitanje;

public class OdgovorActivity extends AppCompatActivity {

    private Animator mCurrentAnimator;
    public int mShortAnimationDuration;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        final Pitanje p = OdgovoriActivity.p;
        int odg = p.getOdgovor();
        setContentView(R.layout.fragment_pitanje4);
        TextView odg1, odg2, odg3, odg4, pitanje;
        pitanje = (TextView) findViewById(R.id.pitanje);
        odg1 = (TextView) findViewById(R.id.odgovor1);
        odg2 = (TextView) findViewById(R.id.odgovor2);
        odg3 = (TextView) findViewById(R.id.odgovor3);
        odg4 = (TextView) findViewById(R.id.odgovor4);

        switch (p.brojOdgovora()) {
            case 2: {
                setContentView(R.layout.fragment_pitanje2);
                pitanje = (TextView) findViewById(R.id.pitanje);
                odg1 = (TextView) findViewById(R.id.odgovor1);
                odg2 = (TextView) findViewById(R.id.odgovor2);
                pitanje.setText(p.getTekst());
                odg1.setText(p.getOdgovori().get(0).getTekst());
                odg2.setText(p.getOdgovori().get(1).getTekst());
                break;
            }
            case 3:{
                setContentView(R.layout.fragment_pitanje3);
                pitanje = (TextView) findViewById(R.id.pitanje);
                odg1 = (TextView) findViewById(R.id.odgovor1);
                odg2 = (TextView) findViewById(R.id.odgovor2);
                odg3 = (TextView) findViewById(R.id.odgovor3);
                pitanje.setText(p.getTekst());
                odg1.setText(p.getOdgovori().get(0).getTekst());
                odg2.setText(p.getOdgovori().get(1).getTekst());
                odg3.setText(p.getOdgovori().get(2).getTekst());
                break;
            }
            case 4:{
                pitanje.setText(p.getTekst());
                odg1.setText(p.getOdgovori().get(0).getTekst());
                odg2.setText(p.getOdgovori().get(1).getTekst());
                odg3.setText(p.getOdgovori().get(2).getTekst());
                odg4.setText(p.getOdgovori().get(3).getTekst());
                break;
            }

        }


        int id = getIntent().getIntExtra("id", 1);
        final View linearLayout =  findViewById(R.id.backgroundLayout);
        linearLayout.setBackground(getResources().getDrawable(MainActivity.idSlike[id]));

        if (p.getId() > 301) {
            final ImageButton mImageView = (ImageButton) findViewById(R.id.imageButton);
            Bitmap bMap = BitmapFactory.decodeResource(getResources(), p.getIdSlike());
            mImageView.setImageBitmap(bMap);

            mImageView.setOnClickListener(new ImageButton.OnClickListener() {
                @Override
                public void onClick(View view) {
                    zoomImageFromThumb(mImageView, p.getIdSlike());
                }
            });
            mShortAnimationDuration = getResources().getInteger(
                    android.R.integer.config_shortAnimTime);


        }
        switch (odg) {
            case 1:
                odg1.setBackgroundColor(Color.GREEN);
                if (p.getOdg2() == 1)
                    odg2.setBackgroundColor(Color.RED);
                if (p.getOdg3() == 1)
                    odg3.setBackgroundColor(Color.RED);
                if (p.getOdg4() == 1)
                    odg4.setBackgroundColor(Color.RED);
                break;
            case 2:
                odg2.setBackgroundColor(Color.GREEN);
                if (p.getOdg1() == 1)
                    odg1.setBackgroundColor(Color.RED);
                if (p.getOdg3() == 1)
                    odg3.setBackgroundColor(Color.RED);
                if (p.getOdg4() == 1)
                    odg4.setBackgroundColor(Color.RED);
                break;
            case 3:
                odg3.setBackgroundColor(Color.GREEN);
                if (p.getOdg2() == 1)
                    odg2.setBackgroundColor(Color.RED);
                if (p.getOdg1() == 1)
                    odg1.setBackgroundColor(Color.RED);
                if (p.getOdg4() == 1)
                    odg4.setBackgroundColor(Color.RED);
                break;
            case 4:
                odg4.setBackgroundColor(Color.GREEN);
                if (p.getOdg2() == 1)
                    odg2.setBackgroundColor(Color.RED);
                if (p.getOdg3() == 1)
                    odg3.setBackgroundColor(Color.RED);
                if (p.getOdg1() == 1)
                    odg1.setBackgroundColor(Color.RED);
                break;
            case 12:
                odg1.setBackgroundColor(Color.GREEN);
                odg2.setBackgroundColor(Color.GREEN);
                if (p.getOdg3() == 1)
                    odg3.setBackgroundColor(Color.RED);
                if (p.getOdg4() == 1)
                    odg4.setBackgroundColor(Color.RED);
                break;
            case 13:
                odg3.setBackgroundColor(Color.GREEN);
                odg1.setBackgroundColor(Color.GREEN);
                if (p.getOdg2() == 1)
                    odg2.setBackgroundColor(Color.RED);
                if (p.getOdg4() == 1)
                    odg4.setBackgroundColor(Color.RED);
                break;
            case 14:
                odg1.setBackgroundColor(Color.GREEN);
                odg4.setBackgroundColor(Color.GREEN);
                if (p.getOdg3() == 1)
                    odg3.setBackgroundColor(Color.RED);
                if (p.getOdg2() == 1)
                    odg2.setBackgroundColor(Color.RED);
                break;
            case 23:
                odg2.setBackgroundColor(Color.GREEN);
                odg3.setBackgroundColor(Color.GREEN);
                if (p.getOdg1() == 1)
                    odg1.setBackgroundColor(Color.RED);
                if (p.getOdg4() == 1)
                    odg4.setBackgroundColor(Color.RED);
                break;
            case 24:
                odg2.setBackgroundColor(Color.GREEN);
                odg4.setBackgroundColor(Color.GREEN);
                if (p.getOdg3() == 1)
                    odg3.setBackgroundColor(Color.RED);
                if (p.getOdg1() == 1)
                    odg1.setBackgroundColor(Color.RED);
                break;
            case 34:
                odg4.setBackgroundColor(Color.GREEN);
                odg3.setBackgroundColor(Color.GREEN);
                if (p.getOdg1() == 1)
                    odg1.setBackgroundColor(Color.RED);
                if (p.getOdg2() == 1)
                    odg2.setBackgroundColor(Color.RED);
                break;
            case 123:
                odg2.setBackgroundColor(Color.GREEN);
                odg3.setBackgroundColor(Color.GREEN);
                odg1.setBackgroundColor(Color.GREEN);
                if (p.getOdg4() == 1)
                    odg4.setBackgroundColor(Color.RED);
                break;
            case 124:
                odg2.setBackgroundColor(Color.GREEN);
                odg1.setBackgroundColor(Color.GREEN);
                odg4.setBackgroundColor(Color.GREEN);
                if (p.getOdg3() == 1)
                    odg3.setBackgroundColor(Color.RED);
                break;
            case 134:
                odg3.setBackgroundColor(Color.GREEN);
                odg1.setBackgroundColor(Color.GREEN);
                odg4.setBackgroundColor(Color.GREEN);
                if (p.getOdg2() == 1)
                    odg2.setBackgroundColor(Color.RED);
                break;
            case 234:
                odg2.setBackgroundColor(Color.GREEN);
                odg3.setBackgroundColor(Color.GREEN);
                odg4.setBackgroundColor(Color.GREEN);
                if (p.getOdg1() == 1)
                    odg1.setBackgroundColor(Color.RED);
                break;
        }
        odg1.setClickable(false);
        odg2.setClickable(false);
        odg3.setClickable(false);
        odg4.setClickable(false);


        if (OdgovoriActivity.toast) {
            Toast.makeText(getApplicationContext(), "Klikni Back",
                    Toast.LENGTH_LONG).show();
            OdgovoriActivity.toast = false;
        }
    }

    private void zoomImageFromThumb(final View thumbView, int imageResId) {
        // If there's an animation in progress, cancel it
        // immediately and proceed with this one.
        if (mCurrentAnimator != null) {
            mCurrentAnimator.cancel();
        }

        // Load the high-resolution "zoomed-in" image.
        final ImageView expandedImageView = (ImageView) findViewById(
                R.id.expanded_image);
        expandedImageView.setImageResource(imageResId);

        // Calculate the starting and ending bounds for the zoomed-in image.
        // This step involves lots of math. Yay, math.
        final Rect startBounds = new Rect();
        final Rect finalBounds = new Rect();
        final Point globalOffset = new Point();

        // The start bounds are the global visible rectangle of the thumbnail,
        // and the final bounds are the global visible rectangle of the container
        // view. Also set the container view's offset as the origin for the
        // bounds, since that's the origin for the positioning animation
        // properties (X, Y).
        thumbView.getGlobalVisibleRect(startBounds);
        findViewById(R.id.backgroundLayout)
                .getGlobalVisibleRect(finalBounds, globalOffset);
        startBounds.offset(-globalOffset.x, -globalOffset.y);
        finalBounds.offset(-globalOffset.x, -globalOffset.y);

        // Adjust the start bounds to be the same aspect ratio as the final
        // bounds using the "center crop" technique. This prevents undesirable
        // stretching during the animation. Also calculate the start scaling
        // factor (the end scaling factor is always 1.0).
        float startScale;
        if ((float) finalBounds.width() / finalBounds.height()
                > (float) startBounds.width() / startBounds.height()) {
            // Extend start bounds horizontally
            startScale = (float) startBounds.height() / finalBounds.height();
            float startWidth = startScale * finalBounds.width();
            float deltaWidth = (startWidth - startBounds.width()) / 2;
            startBounds.left -= deltaWidth;
            startBounds.right += deltaWidth;
        } else {
            // Extend start bounds vertically
            startScale = (float) startBounds.width() / finalBounds.width();
            float startHeight = startScale * finalBounds.height();
            float deltaHeight = (startHeight - startBounds.height()) / 2;
            startBounds.top -= deltaHeight;
            startBounds.bottom += deltaHeight;
        }

        // Hide the thumbnail and show the zoomed-in view. When the animation
        // begins, it will position the zoomed-in view in the place of the
        // thumbnail.
        thumbView.setAlpha(0f);
        expandedImageView.setVisibility(View.VISIBLE);

        // Set the pivot point for SCALE_X and SCALE_Y transformations
        // to the top-left corner of the zoomed-in view (the default
        // is the center of the view).
        expandedImageView.setPivotX(0f);
        expandedImageView.setPivotY(0f);

        // Construct and run the parallel animation of the four translation and
        // scale properties (X, Y, SCALE_X, and SCALE_Y).
        AnimatorSet set = new AnimatorSet();
        set
                .play(ObjectAnimator.ofFloat(expandedImageView, View.X,
                        startBounds.left, finalBounds.left))
                .with(ObjectAnimator.ofFloat(expandedImageView, View.Y,
                        startBounds.top, finalBounds.top))
                .with(ObjectAnimator.ofFloat(expandedImageView, View.SCALE_X,
                        startScale, 1f)).with(ObjectAnimator.ofFloat(expandedImageView,
                View.SCALE_Y, startScale, 1f));
        set.setDuration(mShortAnimationDuration);
        set.setInterpolator(new DecelerateInterpolator());
        set.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                mCurrentAnimator = null;
            }

            @Override
            public void onAnimationCancel(Animator animation) {
                mCurrentAnimator = null;
            }
        });
        set.start();
        mCurrentAnimator = set;

        // Upon clicking the zoomed-in image, it should zoom back down
        // to the original bounds and show the thumbnail instead of
        // the expanded image.
        final float startScaleFinal = startScale;
        expandedImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mCurrentAnimator != null) {
                    mCurrentAnimator.cancel();
                }

                // Animate the four positioning/sizing properties in parallel,
                // back to their original values.
                AnimatorSet set = new AnimatorSet();
                set.play(ObjectAnimator
                        .ofFloat(expandedImageView, View.X, startBounds.left))
                        .with(ObjectAnimator
                                .ofFloat(expandedImageView,
                                        View.Y,startBounds.top))
                        .with(ObjectAnimator
                                .ofFloat(expandedImageView,
                                        View.SCALE_X, startScaleFinal))
                        .with(ObjectAnimator
                                .ofFloat(expandedImageView,
                                        View.SCALE_Y, startScaleFinal));
                set.setDuration(mShortAnimationDuration);
                set.setInterpolator(new DecelerateInterpolator());
                set.addListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        thumbView.setAlpha(1f);
                        expandedImageView.setVisibility(View.GONE);
                        mCurrentAnimator = null;
                    }

                    @Override
                    public void onAnimationCancel(Animator animation) {
                        thumbView.setAlpha(1f);
                        expandedImageView.setVisibility(View.GONE);
                        mCurrentAnimator = null;
                    }
                });
                set.start();
                mCurrentAnimator = set;
            }
        });
    }


}