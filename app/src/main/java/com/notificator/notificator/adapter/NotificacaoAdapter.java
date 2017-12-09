package com.notificator.notificator.adapter;


import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.notificator.notificator.R;
import com.notificator.notificator.model.Contato;
import com.notificator.notificator.model.Notificacao;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class NotificacaoAdapter extends ArrayAdapter<Notificacao> {

    public NotificacaoAdapter(Context context, List<Notificacao> notificacaoList) {
        super(context, R.layout.lista_notificacao, notificacaoList);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final NotificacaoAdapter.ViewHolder holder; if (convertView == null) {
            convertView = View.inflate(getContext(), R.layout.notificacao_item_list, null);
            holder = new NotificacaoAdapter.ViewHolder(); ButterKnife.bind(holder, convertView); convertView.setTag(holder);
        } else {
            holder = (NotificacaoAdapter.ViewHolder) convertView.getTag();
        }
        final Notificacao notificacao = getItem(position);
        if(notificacao != null){
            holder.nome.setText(notificacao.getNomeNotificacao());
            //holder.image.setImageResource(user.image);
        }
        return convertView;
    }

    public class ViewHolder{

        @Bind(R.id.notificacao_item_list_nome)
        TextView nome;
    }


}
