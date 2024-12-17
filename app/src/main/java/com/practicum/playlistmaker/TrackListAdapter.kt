package com.practicum.playlistmaker

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView


class TrackListAdapter(
    private var track: List<Result>, val listener: Listener
) : RecyclerView.Adapter<TrackListHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrackListHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.track_view, parent, false)
        return TrackListHolder(view)
    }

    override fun onBindViewHolder(holder: TrackListHolder, position: Int) {
        holder.bind(track[position], listener)
    }

    override fun getItemCount(): Int = track.size

    interface Listener {
        fun OnClick(track: Result)
    }

    fun updateTracks(newTracks: List<Result>) {
        track = newTracks
        notifyDataSetChanged()
    }

}