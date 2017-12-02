package com.notificator.notificator.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.notificator.notificator.R;
import com.notificator.notificator.model.Contato;

import org.w3c.dom.Text;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ContatoAdapter extends ArrayAdapter<Contato> {

    public ContatoAdapter(Context context, List<Contato> contatoList) {
        super(context, R.layout.contato_item_list, contatoList);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder holder; if (convertView == null) {
            convertView = View.inflate(getContext(), R.layout.contato_item_list, null);
            holder = new ViewHolder(); ButterKnife.bind(holder, convertView); convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        final Contato contato = getItem(position);
        if(contato != null){
            holder.nome.setText(contato.getNome());
            holder.categoria.setText(contato.getCategoria());
            //holder.image.setImageResource(user.image);
        }
        return convertView;
    }

    public class ViewHolder{

        @Bind(R.id.contato_item_list_nome)
        TextView nome;

        @Bind(R.id.contato_item_list_categoria)
        TextView categoria;
    }
}