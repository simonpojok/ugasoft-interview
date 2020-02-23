package com.simonojok19.techman;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class StudentAdaper extends RecyclerView.Adapter<StudentAdaper.StudentViewHold> {

    public class StudentViewHold extends RecyclerView.ViewHolder{
        private final TextView studentName;
        private final TextView studentSchool;
        private final TextView studentDistrict;

        public StudentViewHold(@NonNull View itemView) {
            super(itemView);
            studentName = itemView.findViewById(R.id.text_name);
            studentSchool = itemView.findViewById(R.id.text_school);
            studentDistrict = itemView.findViewById(R.id.text_district);
        }

        public void bindStudent(Student student) {
            studentName.setText(student.getStudentName());
            studentSchool.setText(student.getStudentSchool());
            studentDistrict.setText(student.getStudentDistrict());
        }
    }

    private final LayoutInflater layoutInflater;
    private List<Student> students;


    StudentAdaper(Context context) {
        layoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public StudentViewHold onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.recyclerview_student, parent, false);
        return new StudentViewHold(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentViewHold holder, int position) {
        if (students != null) {
            Student current = students.get(position);
            holder.bindStudent(current);
        }
    }

    @Override
    public int getItemCount() {
        if (students != null) {
            return students.size();
        } else return 0;
    }

    void setStudents(List<Student> students) {
        this.students = students;
        notifyDataSetChanged();
    }
}
