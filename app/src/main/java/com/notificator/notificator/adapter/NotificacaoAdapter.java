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
            convertView = View.inflate(getContext(), R.layout.lista_notificacao, null);
            holder = new NotificacaoAdapter.ViewHolder(); ButterKnife.bind(holder, convertView); convertView.setTag(holder);
        } else {
            holder = (NotificacaoAdapter.ViewHolder) convertView.getTag();
        }
        final Notificacao notificaca = getItem(position);
        if(notificaca != null){
            holder.nomedaNotificacao.setText(notificaca.getNomeNotificacao());
            holder.mensagemNoticacao.setText(notificaca.getNomeNotificacao());
            //holder.image.setImageResource(user.image);
        }
        return convertView;
    }

    public class ViewHolder{

        @Bind(R.id.lista_notificacao_nomeNotificacao)
        TextView nome;

        @Bind(R.id.lista_notificacao_mensagemNoticacao)
        TextView me;

    }


}
