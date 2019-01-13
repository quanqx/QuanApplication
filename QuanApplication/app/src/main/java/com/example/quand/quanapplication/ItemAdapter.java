package com.example.quand.quanapplication;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.daimajia.swipe.SimpleSwipeListener;
import com.daimajia.swipe.SwipeLayout;
import com.daimajia.swipe.adapters.RecyclerSwipeAdapter;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class ItemAdapter extends RecyclerSwipeAdapter<ItemAdapter.ViewHolder>{

    Context context;
    ArrayList<Item> items;

    public ItemAdapter(Context context, ArrayList<Item> items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.item_row, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, int i) {
        viewHolder.imgItem.setImageResource(items.get(i).getImage());
        viewHolder.itemName.setText(items.get(i).getName());

        viewHolder.swipeLayout.setShowMode(SwipeLayout.ShowMode.PullOut);
        viewHolder.swipeLayout.addDrag(SwipeLayout.DragEdge.Left, viewHolder.swipeLayout.findViewById(R.id.bottom_wrapper));

        viewHolder.swipeLayout.addSwipeListener(new SwipeLayout.SwipeListener() {
            @Override
            public void onStartOpen(SwipeLayout layout) {

            }

            @Override
            public void onOpen(SwipeLayout layout) {

            }

            @Override
            public void onStartClose(SwipeLayout layout) {

            }

            @Override
            public void onClose(SwipeLayout layout) {

            }

            @Override
            public void onUpdate(SwipeLayout layout, int leftOffset, int topOffset) {

            }

            @Override
            public void onHandRelease(SwipeLayout layout, float xvel, float yvel) {

            }

        });

//        viewHolder.setItemClickListener(new ItemClickListener() {
//            @Override
//            public void onClick(View v, int pos, boolean isLongClick) {
//                if(isLongClick)
//                    Toast.makeText(context, "Long click: " + pos, Toast.LENGTH_SHORT).show();
//                Toast.makeText(context, "Click: " + pos, Toast.LENGTH_SHORT).show();
//            }
//        });

        viewHolder.swipeLayout.getSurfaceView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "swipe.onclick", Toast.LENGTH_SHORT).show();
            }
        });

        viewHolder.tvDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                items.remove(viewHolder.getPos());
                notifyDataSetChanged();
            }
        });
        
        viewHolder.tvEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "edit", Toast.LENGTH_SHORT).show();
            }
        });
//        mItemManger.removeShownLayouts(viewHolder.swipeLayout);
        mItemManger.closeAllItems();
        mItemManger.bindView(viewHolder.itemView, i);

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public int getSwipeLayoutResourceId(int position) {
        return R.id.swipe_item;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener{

        ImageView imgItem;
        TextView itemName;
        ItemClickListener itemClickListener;
        SwipeLayout swipeLayout;
        TextView tvDelete;
        TextView tvEdit;

        public void setItemClickListener(ItemClickListener itemClickListener) {
            this.itemClickListener = itemClickListener;
        }

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgItem = itemView.findViewById(R.id.imgItem);
            itemName = itemView.findViewById(R.id.txtItemName);
            swipeLayout = itemView.findViewById(R.id.swipe_item);
            tvDelete = itemView.findViewById(R.id.tvDelete);
            tvEdit = itemView.findViewById(R.id.tvEdit);
            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);
        }

        @Override
        public void onClick(View view) {
            itemClickListener.onClick(view, getAdapterPosition(), false);
        }

        @Override
        public boolean onLongClick(View view) {
            itemClickListener.onClick(view, getAdapterPosition(), true);
            return true;
        }

        public int getPos(){
            return getAdapterPosition();
        }

    }
}

interface ItemClickListener{
    void onClick(View v, int pos, boolean isLongClick);
}
