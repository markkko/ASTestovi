package markko.testoviassprint;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ZavrsiFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ZavrsiFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ZavrsiFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public ZavrsiFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ZavrsiFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ZavrsiFragment newInstance(String param1, String param2) {
        ZavrsiFragment fragment = new ZavrsiFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View w = inflater.inflate(R.layout.fragment_zavrsi, container, false);
        Button bt = (Button) w.findViewById(R.id.buttonZavrsi);
        final Button[] buttons = new Button[40];
        buttons[0] = (Button) w.findViewById(R.id.button1);
        buttons[1] = (Button) w.findViewById(R.id.button2);
        buttons[2] = (Button) w.findViewById(R.id.button3);
        buttons[3] = (Button) w.findViewById(R.id.button4);
        buttons[4] = (Button) w.findViewById(R.id.button5);
        buttons[5] = (Button) w.findViewById(R.id.button6);
        buttons[6] = (Button) w.findViewById(R.id.button7);
        buttons[7] = (Button) w.findViewById(R.id.button8);
        buttons[8] = (Button) w.findViewById(R.id.button9);
        buttons[9] = (Button) w.findViewById(R.id.button10);
        buttons[10] = (Button) w.findViewById(R.id.button11);
        buttons[11] = (Button) w.findViewById(R.id.button12);
        buttons[12] = (Button) w.findViewById(R.id.button13);
        buttons[13] = (Button) w.findViewById(R.id.button14);
        buttons[14] = (Button) w.findViewById(R.id.button15);
        buttons[15] = (Button) w.findViewById(R.id.button16);
        buttons[16] = (Button) w.findViewById(R.id.button17);
        buttons[17] = (Button) w.findViewById(R.id.button18);
        buttons[18] = (Button) w.findViewById(R.id.button19);
        buttons[19] = (Button) w.findViewById(R.id.button20);
        buttons[20] = (Button) w.findViewById(R.id.button21);
        buttons[21] = (Button) w.findViewById(R.id.button22);
        buttons[22] = (Button) w.findViewById(R.id.button23);
        buttons[23] = (Button) w.findViewById(R.id.button24);
        buttons[24] = (Button) w.findViewById(R.id.button25);
        buttons[25] = (Button) w.findViewById(R.id.button26);
        buttons[26] = (Button) w.findViewById(R.id.button27);
        buttons[27] = (Button) w.findViewById(R.id.button28);
        buttons[28] = (Button) w.findViewById(R.id.button29);
        buttons[29] = (Button) w.findViewById(R.id.button30);
        buttons[30] = (Button) w.findViewById(R.id.button31);
        buttons[31] = (Button) w.findViewById(R.id.button32);
        buttons[32] = (Button) w.findViewById(R.id.button33);
        buttons[33] = (Button) w.findViewById(R.id.button34);
        buttons[34] = (Button) w.findViewById(R.id.button35);
        buttons[35] = (Button) w.findViewById(R.id.button36);
        buttons[36] = (Button) w.findViewById(R.id.button37);
        buttons[37] = (Button) w.findViewById(R.id.button38);
        buttons[38] = (Button) w.findViewById(R.id.button39);
        buttons[39] = (Button) w.findViewById(R.id.button40);

        int i;
        for (i=0; i<40; i++) {
            Button button = buttons[i];
            if (MainActivity.kontroler.getPitanja().get(i).isOdgovoreno())
                button.setBackgroundColor(Color.BLUE);

            final int m=i;
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int id =  v.getId();
                    int j;
                    for (j=0; j<m; j++)
                        if (id == buttons[j].getId())
                            break;
                    MainActivity.mViewPager.setCurrentItem(j);
                }
            });
        }

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), OdgovoriActivity.class);
                startActivity(i);
                getActivity().finish();
            }
        });
        return w;

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
