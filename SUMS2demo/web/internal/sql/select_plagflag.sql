select * from final_project p, marks m where plagiarism_suspect = 'Y' 
and m.project_id = p.project_id