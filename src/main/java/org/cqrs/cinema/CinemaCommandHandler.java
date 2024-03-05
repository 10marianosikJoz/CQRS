package org.cqrs.cinema;

class CinemaCommandHandler {

    private final CinemaWriteRepository cinemaWriteRepository;

    CinemaCommandHandler(final CinemaWriteRepository cinemaWriteRepository) {
        this.cinemaWriteRepository = cinemaWriteRepository;
    }

    Cinema handleCreateCinemaCommand(CreateCinemaCommand createCinemaCommand) {
        var cinema = new Cinema(createCinemaCommand.cinemaId(),
                                createCinemaCommand.address(),
                                createCinemaCommand.repertoire());

        return cinemaWriteRepository.putNewCinema(cinema);
    }

    Cinema handleUpdateCinemaCommand(UpdateCinemaCommand updateCinemaCommand) {
        var cinema = new Cinema(updateCinemaCommand.cinemaId(),
                                updateCinemaCommand.address(),
                                updateCinemaCommand.repertoire());

        return cinemaWriteRepository.putNewCinema(cinema);
    }
}
