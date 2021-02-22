package com.test.datatest.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.test.datatest.R
import com.test.datatest.data.RecyclerList

class RecyclerAdapter : RecyclerView.Adapter<RecyclerAdapter.UserSettingHolder>() {
    interface ItemClick {
        fun onClick(view: View, position: Int)
    }

    private var items: MutableList<RecyclerList> = mutableListOf(
            RecyclerList("소개 메시지 변경", "소개 메시지(DB)"),
            RecyclerList("지역 변경", "해당 지역(DB)"),
            RecyclerList("자격증 수정", "자격증(DB)"),
            RecyclerList("정보 공개 여부", "정보공개여부(DB)"),
            RecyclerList("닉네임 수정", "닉네임(DB)"),
            RecyclerList("휴대폰 번호 변경", "핸드폰정보(DB)")
    )

    var itemClick: ItemClick? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserSettingHolder = UserSettingHolder(parent)

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: UserSettingHolder, position: Int) {
        if (itemClick != null) {
            holder.itemView.setOnClickListener { v ->
                itemClick?.onClick(v, position)
            }
        }

        items[position].let { item ->
            with(holder) {
                settingName.text = item.settingName
                settingDetail.text = item.settingDetail
            }
        }
    }

    inner class UserSettingHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_item, parent, false)) {
        val settingName = itemView?.setting_name
        val settingDetail = itemView?.setting_detail



    }
}



