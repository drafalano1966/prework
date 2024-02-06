package com.example.mvvm.adapter

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvm.R
import com.example.mvvm.data.ResponseItem
import com.example.mvvm.databinding.ResponseListRowBinding

class ResponseListAdapter: RecyclerView.Adapter<ResponseListAdapter.responseViewHolder>() {

    private var responseList : List<ResponseItem>? = null

    fun setResponseList(responseList: List<ResponseItem>?){
        this.responseList = responseList
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ResponseListAdapter.responseViewHolder {

        return responseViewHolder(ResponseListRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        )
    }

    override fun onBindViewHolder(holder: ResponseListAdapter.responseViewHolder, position: Int) {
        responseList?.let {
            holder.bind(it[position])
        }
    }

    override fun getItemCount(): Int {
        if (responseList == null) return 0
        else return responseList?.size!!

    }

    class responseViewHolder(val binding: ResponseListRowBinding) : RecyclerView.ViewHolder(binding.root){
        val tvID = binding.tvID
        val tvTitle = binding.tvTitle
        val tvCompleted = binding.tvCompleted
        val tvUserID = binding.tvUserID

        fun bind(data: ResponseItem){
            tvID.text = "ID: ${data.id.toString()}"
            tvTitle.text = "Title:${data.title}"
            tvCompleted.text = "Completed?: ${data.completed.toString()}"
            tvUserID.text = "User iD: ${data.userId.toString()}"
        }

    }
}