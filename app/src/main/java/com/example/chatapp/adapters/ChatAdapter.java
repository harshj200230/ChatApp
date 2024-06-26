package com.example.chatapp.adapters;

import android.graphics.Bitmap;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.chatapp.databinding.ItemContainerReceivedMessageBinding;
import com.example.chatapp.databinding.ItemContainerSentMessageBinding;
import com.example.chatapp.models.ChatMessage;

import java.util.List;

public class ChatAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final List<ChatMessage> chatMessages;
    private Bitmap receiverProfileImage;
    private final String senderId;

    public static final int VIEW_TYPE_SENT = 1;
    public static final int VIEW_TYPE_RECEIVED = 2;

    public void setReceiverProfileImage(Bitmap bitmap){
        receiverProfileImage = bitmap;
    }

    public ChatAdapter(List<ChatMessage> chatMessages, Bitmap receiverProfileImage, String senderId) {
        this.chatMessages = chatMessages;
        this.receiverProfileImage = receiverProfileImage;
        this.senderId = senderId;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == VIEW_TYPE_SENT) {
            return new SentMessageViewHolder(
                    ItemContainerSentMessageBinding.inflate(
                            LayoutInflater.from(parent.getContext()), parent, false
                    )
            );
        } else {
            return new ReceivedMessageViewHolder(
                    ItemContainerReceivedMessageBinding.inflate(
                            LayoutInflater.from(parent.getContext()), parent, false
                    )

            );
        }

    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if(chatMessages.size() > position) {
            //Log.d("PROBLEM","position is "+position);
            //Log.d("PROBLEM","list size is "+chatMessages.size());
            if (getItemViewType(position) == VIEW_TYPE_SENT) {
                ((SentMessageViewHolder) holder).setData(chatMessages.get(position));
            } else {
                ((ReceivedMessageViewHolder) holder).setData(chatMessages.get(position), receiverProfileImage);
            }
        }
    }

    @Override
    public int getItemCount() {
        return chatMessages.size();
    }

    @Override
    public int getItemViewType(int position) {
        Log.e("SIZE_ERROR: ", "size: " + chatMessages.size() + ", position: " + position);
        if(chatMessages.size() > position) {
            if (chatMessages.get(position).senderId.equals(senderId)) {
                return VIEW_TYPE_SENT;
            } else {
                return VIEW_TYPE_RECEIVED;
            }
        }
        return VIEW_TYPE_SENT;
    }

    static class SentMessageViewHolder extends RecyclerView.ViewHolder {

        private final ItemContainerSentMessageBinding binding;

        SentMessageViewHolder(ItemContainerSentMessageBinding itemContainerSentMessageBinding) {
            super(itemContainerSentMessageBinding.getRoot());
            binding = itemContainerSentMessageBinding;
        }

        void setData(ChatMessage chatMessage) {
            if(binding != null) {
                binding.textMessage.setText(chatMessage.message);
                binding.textDateTime.setText(chatMessage.dateTime);
            }

        }
    }

    static class ReceivedMessageViewHolder extends RecyclerView.ViewHolder {

        private final ItemContainerReceivedMessageBinding binding;

        ReceivedMessageViewHolder(ItemContainerReceivedMessageBinding itemContainerReceivedMessageBinding) {
            super(itemContainerReceivedMessageBinding.getRoot());
            binding = itemContainerReceivedMessageBinding;

        }

        void setData(ChatMessage chatMessage, Bitmap receiverProfileImage) {
            if(binding != null) {
                binding.textMessage.setText(chatMessage.message);
                binding.textDateTime.setText(chatMessage.dateTime);
            }
            if (receiverProfileImage!=null){
                binding.imageProfile.setImageBitmap(receiverProfileImage);
            }


        }
    }
}
