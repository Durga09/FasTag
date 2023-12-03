package com.agent.fasttag.view.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.agent.fasttag.R
import com.agent.fasttag.databinding.LayoutTlBottomAdapeterBinding
import com.agent.fasttag.view.model.ReponseData


class TeamLeadsListAdapter(private val dataSet: ArrayList<ReponseData>,val callBack : (ReponseData) -> Unit) :
    RecyclerView.Adapter<TeamLeadsListAdapter.ViewHolder>() {

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder)
     */


    inner class ViewHolder(val binding: LayoutTlBottomAdapeterBinding) : RecyclerView.ViewHolder(binding.root) {
        /* val userName: TextView
        val phoneNo: TextView
        val email: TextView
        val role: TextView

        init {
            // Define click listener for the ViewHolder's View
            userName = view.findViewById(R.id.name)
            phoneNo = view.findViewById(R.id.phone_number)
            email = view.findViewById(R.id.email)
            role = view.findViewById(R.id.role)

        }*/
        fun bind(dataSet: ReponseData) {
            val context = binding.root.context
            binding.name.text = "Name : " + dataSet.userName
            binding.phoneNumber.text = "Contact : " + dataSet.phoneNumber
            binding.email.text = "Email : " + dataSet.email
            binding.role.text = "Role : " + dataSet.roleName
            binding.root.setOnClickListener {
                callBack.invoke(dataSet)
            }
        }
    }
        // Create new views (invoked by the layout manager)

        override fun onCreateViewHolder(
            parent: ViewGroup,
            viewType: Int
        ): ViewHolder {
            val binding = LayoutTlBottomAdapeterBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
            return ViewHolder(binding)

        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.bind(dataSet[position])
        }

    override fun getItemCount(): Int {
        return dataSet.size
    }
}
    // Replace the contents of a view (invoked by the layout manager)
   /* @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        println("onBindViewHolder:: "+dataSet[position].userName)
        viewHolder.userName.text = "Name : "+dataSet[position].userName
        viewHolder.phoneNo.text = "Contact : "+dataSet[position].phoneNumber
        viewHolder.email.text = "Email : "+dataSet[position].email
        viewHolder.role.text = "Role : "+dataSet[position].roleName

        viewHolder.itemView.setOnClickListener {
            callBack.invoke(dataSet[position] )

//            if (onItemClickListener != null) {
//                onItemClickListener!!.onItem(position, dataSet[position] )
//            }
        }
    }*/

    // Return the size of your dataset (invoked by the layout manager)
//    override fun getItemCount() = dataSet.size


