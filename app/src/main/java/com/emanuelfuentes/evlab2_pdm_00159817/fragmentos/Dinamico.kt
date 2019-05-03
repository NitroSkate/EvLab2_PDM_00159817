package com.emanuelfuentes.evlab2_pdm_00159817.fragmentos

import android.content.Context
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

import com.emanuelfuentes.evlab2_pdm_00159817.R
import kotlinx.android.synthetic.main.fragment_dinamico.*
import kotlinx.android.synthetic.main.fragment_dinamico.view.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [Dinamico.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [Dinamico.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class Dinamico : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var num: Int? = null
    private var cont = 0
    private var cont2 = 250
    private var listener: OnFragmentInteractionListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_dinamico, container, false).apply{
            mas.setOnClickListener {
                if(num==0){
                    colour.setBackgroundColor(Color.rgb(cont,0,0))
                }
                if(num==1){
                    colour.setBackgroundColor(Color.rgb(0,cont,0))
                }
                if(num==2){
                    colour.setBackgroundColor(Color.rgb(0,0,cont))
                }
                cont+=10
            }
            menos.setOnClickListener {
                if(num==0){
                    colour.setBackgroundColor(Color.rgb(cont2,0,0))
                }
                if(num==1){
                    colour.setBackgroundColor(Color.rgb(0,cont2,0))
                }
                if(num==2){
                    colour.setBackgroundColor(Color.rgb(0,0,cont2))
                }
                cont2-=10
                if(cont2< 0){
                    cont2=250
                }
            }
        }
        if(num==0){
            view.colour.setBackgroundColor(Color.RED)
        }
        if(num==1){
            view.colour.setBackgroundColor(Color.GREEN)
        }
        if(num==2){
            view.colour.setBackgroundColor(Color.BLUE)
        }
        Log.d("num", Color.RED.toString())
        return view
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnFragmentInteractionListener) {
            listener = context
        } else {
            //throw RuntimeException(context.toString() + " must implement OnFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     *
     *
     * See the Android Training lesson [Communicating with Other Fragments]
     * (http://developer.android.com/training/basics/fragments/communicating.html)
     * for more information.
     */
    interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        fun onClickButton2()
    }

    companion object {

        fun newInstance(n : Int) : Dinamico {
            val frag = Dinamico()
            frag.num = n
            return frag

            }
    }
}
