package com.example.myapplication

import com.example.myapplication.api.models.Item
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_question.view.*

class QuestionsRecyclerAdapter(
    private val items: List<Item>,
    private val onClick: (item: Item) -> Unit
): RecyclerView.Adapter<QuestionsRecyclerAdapter.QuestionsViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuestionsViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return QuestionsViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: QuestionsViewHolder, position: Int) {
        holder.bind(items[position])
    }

    inner class QuestionsViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
        RecyclerView.ViewHolder(inflater.inflate(R.layout.item_question, parent, false)){

        fun bind(item: Item){
            itemView.apply {
                textQuestion.text = item.title
                Picasso.get().load(item.owner.profileImage).into(imgProfil)
                setOnClickListener { onClick(item) }
            }
        }
    }

    override fun getItemCount() = items.size

}