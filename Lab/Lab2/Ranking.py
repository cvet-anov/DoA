class Ranking:

  def calculate(self, N, z):

    nie = sum(z[0:3]) - min(z[0:3])

    # print(nie)

    ostanati = z[3:]

    ostanati.sort(reverse=True)

    # print(ostanati)


    res = 1



    while len(ostanati) > 2:

        kandidat = ostanati[0]

        partner = -1

        for i in range(1, len(ostanati)):

            if kandidat + ostanati[i] > nie:

                partner = i

        if partner == -1:

            break



        ostanati[0] = ostanati[partner] = -1

        ostanati = [o for o in ostanati if o != -1]





        res += 1





    return res





# r = Ranking()

# print(r.calculate(3, [5,7,3,5,7,3,5,7,3]))