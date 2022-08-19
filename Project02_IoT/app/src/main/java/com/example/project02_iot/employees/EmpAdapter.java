package com.example.project02_iot.employees;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project02_iot.R;

import java.util.ArrayList;

public class EmpAdapter extends RecyclerView.Adapter<EmpAdapter.ViewHolder>{
    LayoutInflater inflater;
    ArrayList<EmployeeVO> list;
    Context context;
    EmpFragment fragment;


    public EmpAdapter(LayoutInflater inflater, ArrayList<EmployeeVO> list, Context context, EmpFragment fragment) {
        this.inflater = inflater;
        this.list = list;
        this.context = context;
        this.fragment = fragment;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.item_emp_recv, parent,false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(holder, position);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView emp_name, emp_id, dept_name, emp_email;
        LinearLayout ln_emp;    //<= 이미지 뷰나 텍스트 뷰를 클릭하게하는게 아니라
                                //레이아웃 자체를 클릭하게 만듦

        public ViewHolder(@NonNull View v) {
            super(v);
            emp_email = v.findViewById(R.id.emp_email);
            dept_name = v.findViewById(R.id.dept_name);
            emp_id = v.findViewById(R.id.emp_id);
            emp_name = v.findViewById(R.id.emp_name);
            ln_emp = v.findViewById(R.id.ln_emp);
        }

        public void bind(@NonNull ViewHolder holder, int i) {
            holder.emp_email.setText(list.get(i).getEmail());
            holder.dept_name.setText(list.get(i).getDepartment_name());
            holder.emp_id.setText(list.get(i).getEmployee_id()+"");
            holder.emp_name.setText(list.get(i).getName());
            holder.ln_emp.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    EmpDialog dialog = new EmpDialog(fragment.getContext());
                    dialog.show();
                }
            });
        }
    }
}
