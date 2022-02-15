package com.traineeapp.model.service;

import java.util.List;

import com.traineeapp.model.persistance.trainee.Trainee;

public interface TraineeService {

	public List<Trainee> allTrainees();

	public Trainee addTrainee(Trainee trainee);

	public Trainee getTraineeById(int id);
}
