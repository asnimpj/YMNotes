package com.yesmeal.yesmealnotes.fragments.navigation

import android.app.Fragment
import android.app.FragmentManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.yesmeal.yesmealnotes.R
import com.yesmeal.yesmealnotes.adapters.PreviousOrderAdapter

import com.yesmeal.yesmealnotes.models.Order
import kotlinx.android.synthetic.main.common_list_view.*

/**
 * Created by asnimansari on 03/02/18.
 */
class PreviousOrders: Fragment(){
    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var database = MySqlHelper.getInstance(context)
        var previousOrders = database.selectPreviousOrder()
        val fragmentManger: FragmentManager = fragmentManager
        var arrAdap = PreviousOrderAdapter(context, previousOrders as List<Order>,fragmentManger,this)
        listView.adapter = arrAdap

    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.common_list_view,container,false)
    }
}