package markko.testoviassprint;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import markko.testoviassprint.Pitanja.Pitanje;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Pitanje2Fragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Pitanje2Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TeorijaFragment extends Fragment {

    private int val;

    private TextView odg1, odg2, odg3, odg4;
    private Pitanje p;

    private OnFragmentInteractionListener mListener;

    public TeorijaFragment() {
        // Required empty public constructor
    }

    public static TeorijaFragment newInstance(int pos) {
        TeorijaFragment fragment = new TeorijaFragment();
        Bundle args = new Bundle();
        args.putInt("val", pos);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            val = getArguments().getInt("val");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View result = inflater.inflate(R.layout.fragment_teorija, container, false);

        result.setBackground(getActivity().getResources().getDrawable(MainActivity.idSlike[val]));
        MainActivity.seekBar.setProgress(val);
        p = MainActivity.kontroler.getPitanja().get(val);
        TextView pitanje = (TextView)result.findViewById(R.id.pitanje);
        odg1 = (TextView)result.findViewById(R.id.odgovor1);
        odg2 = (TextView)result.findViewById(R.id.odgovor2);
        odg3 = (TextView)result.findViewById(R.id.odgovor3);
        odg4 = (TextView)result.findViewById(R.id.odgovor4);
        pitanje.setText(p.getTekst());
        odg1.setText(p.getOdgovori().get(0).getTekst());
        odg2.setText(p.getOdgovori().get(1).getTekst());



        if (p.getOdg1()==1)
            odg1.setBackgroundColor(0x73ffffff);
        if (p.getOdg2()==1)
            odg2.setBackgroundColor(0x73ffffff);

        odg1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (MotionEvent.ACTION_UP == event.getAction()) {
                    if (p.getOdg1() == 1) {
                        //int color = Color.parseColor("26FFFFFF");
                        odg1.setBackgroundColor(0x26ffffff);
                        p.setOdg1(0);
                    } else {
                        //int color = Color.parseColor("59FFFFFF");
                        odg1.setBackgroundColor(0x73ffffff);
                        p.setOdg1(1);
                    }
                }
                return false;
            }
        });
        odg2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(MotionEvent.ACTION_UP == event.getAction()){
                    if (p.getOdg2() == 1) {
                        //int color = Color.parseColor("26FFFFFF");
                        odg2.setBackgroundColor(0x26ffffff);
                        p.setOdg2(0);
                    } else {
                        //int color = Color.parseColor("59FFFFFF");
                        odg2.setBackgroundColor(0x73ffffff);
                        p.setOdg2(1);
                    }
                }
                return false;
            }
        });
        if (p.getOdgovori().size()>2) {
            odg3.setText(p.getOdgovori().get(2).getTekst());
            if (p.getOdg3()==1)
                odg3.setBackgroundColor(0x73ffffff);
            odg3.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    if (MotionEvent.ACTION_UP == event.getAction()) {
                        if (p.getOdg3() == 1) {
                            //int color = Color.parseColor("26FFFFFF");
                            odg3.setBackgroundColor(0x26ffffff);
                            p.setOdg3(0);
                        } else {
                            //int color = Color.parseColor("59FFFFFF");
                            odg3.setBackgroundColor(0x73ffffff);
                            p.setOdg3(1);
                        }
                    }
                    return false;
                }
            });
            if (p.getOdgovori().size()==4) {
                odg4.setText(p.getOdgovori().get(3).getTekst());
                if (p.getOdg4()==1)
                    odg4.setBackgroundColor(0x73ffffff);
                odg4.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        if(MotionEvent.ACTION_UP == event.getAction()){
                            if (p.getOdg4() == 1) {
                                //int color = Color.parseColor("26FFFFFF");
                                odg4.setBackgroundColor(0x26ffffff);
                                p.setOdg4(0);
                            } else {
                                //int color = Color.parseColor("59FFFFFF");
                                odg4.setBackgroundColor(0x73ffffff);
                                p.setOdg4(1);
                            }
                        }
                        return false;
                    }
                });
            }
            else
                odg4.setVisibility(View.INVISIBLE);
        }
        else
            odg3.setVisibility(View.INVISIBLE);
        if (p.getOdgovori().size()==2)
            odg4.setVisibility(View.INVISIBLE);

        return result;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();

        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
