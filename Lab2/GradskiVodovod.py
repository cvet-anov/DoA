class GradskiVodovod:

    def weight(self, cevka):

        return cevka[2] * 7 + cevka[3]

    def poroshuvachka(self, N, K, m):

        vkupno = 0

        grupi = list(range(N))

        cevki = [tuple(map(int, c.split(' '))) for c in m]

        cevki.sort(key=lambda c: self.weight(c))

        for cevka in cevki:

            if grupi[cevka[0]] == grupi[cevka[1]]:
                continue

            raspored = min(grupi[cevka[0]], grupi[cevka[1]])

            for i in range(len(grupi)):

                if grupi[i] == cevka[0] or grupi[i] == cevka[1]:
                    grupi[i] = raspored

            vkupno += self.weight(cevka)

        return vkupno